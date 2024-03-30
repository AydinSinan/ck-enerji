
Bu projede Backend servisi, ürünleri yönetmek için RESTful API'lar sağlar; ürün ekleme, listeleme, güncelleme ve silme gibi işlevleri içerir. API güvenliğini sağlamak için basit kimlik doğrulama (Basic Authentication) kullanılmıştır. Veritabanı mikroservisi, Node.js ve Express.js kullanılarak geliştirilmiş olup, MongoDB veritabanı ile entegre edilmiştir. Java backend'den gelen istekler, MongoDB ile etkileşim için Mongoose kullanılarak Node.js mikroservisine yönlendirilir.

## Özellikler
- **Java Spring Boot Backend**:
  - Java 11 ve Spring Boot kullanılarak RESTful API'lar geliştirilir.
  - Ürün yönetimi için CRUD işlemleri uygulanır.
  - API güvenliği, Basit Kimlik Doğrulama ile sağlanır.
  
- **Node.js Veritabanı Mikroservisi**:
  - Node.js ve Express.js kullanılarak bir mikroservis geliştirilir.
  - MongoDB veritabanı ile entegre edilir.
  - Java backend'den gelen istekleri istekleri alınıp, veritabanı işlemlerini gerçekleştirilir.

- **Docker**:
  - Java backend ve Node.js mikroservisi için Docker dosyaları oluşturulur.
  - Docker Compose kullanılarak tüm servislerin bir arada çalıştırılması sağlanır.
  - Geliştirme ve test için yerel ortamda kolayca başlatılır.

## Kurulum Talimatları
1. **Ön Koşullar**:
   - Java 17 veya üst sürümü kurulu olmalıdır.
   - Node.js ve npm kurulu olmalıdır.
   - Local database bağlantıları için MongoDB Compass kurulu olmalıdır.
   - Docker ve Docker Compose kurulu olmalıdır.

2. **Uygulamaları Ayağa Kaldırma**:
    - Her iki servis için servislerin bulunduğu dizine girin.
      
    -- Node.js için "npm install" ile bağımlılıkları yükledikten sonra npm start ile uygulamayı ayağa kaldırabilirsiniz.

    -- Java Spring Boot için IDE ile uygulamayı açtıktan sonra uygulamayı derleyip çalıştırabilirsiniz. 

3. **Docker**
    - İlgili uygulamaları docker ile ayağa kaldırmak isterseniz, uygulamaların ana dizininde terminalde sırasıyla;
    ## docker-compose build
    ## docker-compose up
komutlarını kullanarak ayağa kaldırabilirsiniz.

4. **Endpoint Listeleri**:

    #### GET - http://localhost:8080/api/products/getAllProducts
    #### GET - http://localhost:8080/api/products/getProduct/{id}
    #### POST - http://localhost:8080/api/products
    #### PUT - http://localhost:8080/api/products/{id}
    #### DELETE - http://localhost:8080/api/products/6607dd3a74134405af50b3a1

5. **Güvenlik Katmanı**

 Postman ile ilgili endpointlere istek atarken Authorization katmanına dikkat edin.Basic Auth seçeneği ile Username ve Password kısımlarını her iki kısım için "admin" yazarak isteklere erişebilirsiniz.
