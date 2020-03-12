var Store = {

  "Products": [
    {'sku': 'D33H1', 'name': 'Macbook pro 13 inch', 'price': 1500, 'description': '3-inch MacBook Pro with Retina display', 'isAvailable': true}
  ],

  
  saveProduct: function(JSON){
    console.log('Product has been saved');
  },
  
  getProduct: function(SKU){
    
  },
  
  
  
}

document.getElementById('add-product-form').addEventListener('submit', function () {
  Store.saveProduct();
});

for(var i = 0; i < Store.Products.length; )
var obj = Store.Products[0];
console.log(obj);