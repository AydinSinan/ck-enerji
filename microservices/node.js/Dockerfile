# Node.js tabanlı bir çalışma zamanı görüntüsü kullanıyoruz
FROM node:latest

# Uygulamanın çalışacağı dizin
WORKDIR /app

# package.json ve package-lock.json kopyalanır ve bağımlılıklar yüklenir
COPY package*.json ./
RUN npm install

# Uygulama kaynak dosyalarını kopyala
COPY . .

# Uygulamayı başlat
CMD ["node", "app.js"]
