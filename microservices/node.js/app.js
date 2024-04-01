const express = require('express');
const mongoose = require('mongoose');

mongoose.connect('mongodb://127.0.0.1:27017/products')
    .then(() => console.log('MongoDB bağlantısı başarılı'))
    .catch(err => console.error('MongoDB bağlantı hatası:', err)); 


const productSchema = new mongoose.Schema({
    name: String,
    price: Number
});

const Product = mongoose.model('Product', productSchema);

const app = express();
app.use(express.json());

app.get('/', async(req, res) => {
    res.send('<h3>CK Enerji</h3>')
})

app.get('/api/getAllProducts', async (req, res) => {
    try {
        const products = await Product.find();
        res.json(products);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

app.get('/api/getProduct/:id', async (req, res) => {
    try {
        const product = await Product.findById(req.params.id);
        if (!product) {
            return res.status(404).json({ message: 'Ürün bulunamadı' });
        }
        res.json(product);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


app.post('/api/addProduct', async (req, res) => {
    try {
        const product = new Product({
            name: req.body.name,
            price: req.body.price
        });
        await product.save();
        res.status(201).json(product);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});



app.put('/api/updateProduct/:id', async (req, res) => {
    try {
        const product = await Product.findByIdAndUpdate(req.params.id, req.body, { new: true });
        if (!product) {
            return res.status(404).json({ message: 'Ürün bulunamadı' });
        }
        res.json(product);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


app.delete('/api/deleteProduct/:id', async (req, res) => {
    try {
        const product = await Product.findByIdAndDelete(req.params.id);
        if (!product) {
            return res.status(404).json({ message: 'Ürün bulunamadı' });
        }
        res.json({ message: 'Ürün başarıyla silindi' });
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});


const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Server ${port} portunda çalışıyor`));
