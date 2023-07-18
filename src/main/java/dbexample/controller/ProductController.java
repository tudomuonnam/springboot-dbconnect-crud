package dbexample.controller;

import dbexample.model.Product;
import dbexample.model.ResponseObject;
import dbexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

//    public ProductController(ProductRepository productRepository){
//        this.productRepository = productRepository;
//    }
    @GetMapping("")
    public ResponseEntity getAllProduct(){
        return ResponseEntity.ok(productRepository.findAll());
    }
    @RequestMapping("/{id}")
    public ResponseEntity getDetailProduct(@PathVariable Long id){
      return ResponseEntity.ok(productRepository.findById(id));
    }
    @PostMapping("/insert")
    public ResponseEntity postProduct(@RequestBody Product newProduct){
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("OK","Insert successfully",productRepository.save(newProduct)));
        List<Product> foundProduct = productRepository.findByName(newProduct.getName().trim());
        if(foundProduct.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Fail","Product already taken",""));
        }
        return (ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Success",
                        "Insert Product Successfully",productRepository.save(newProduct))
        ));
    };
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
      Product updateProduct = productRepository.findById(id)
              .map(product -> {
                  product.setDescription(newProduct.getDescription());
                  product.setName(newProduct.getName());
                  return productRepository.save(product);
              }).orElseGet(() -> {
                  newProduct.setId(id);
                  return productRepository.save(newProduct);
              });
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("OK","Update product successfully",updateProduct)
      );
    };
    //DELETE product
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        boolean existProduct = productRepository.existsById(id);
        if(existProduct){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete Product Successfully","")
            );
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed","Can not found product to delete","")
        );
    }
}
