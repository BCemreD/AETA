-- TAGS
INSERT INTO tags (name) VALUES
('Java'),
('Spring Boot'),
('Frontend'),
('Cloud'),
('Data Science');

-- CATEGORIES
INSERT INTO categories (name) VALUES
('Yazılım Geliştirme'),
('Mobil Uygulama'),
('Veri Bilimi'),
('Bulut Bilişim'),
('Kariyer');

-- JOBS
INSERT INTO jobs (title, description, created_at, updated_at, created_by, updated_by) VALUES
('Java Backend Developer', 'Spring Boot, REST API ve microservice mimarisi üzerine backend geliştirme', NOW(), NOW(), 'system', 'system'),
('Frontend Developer', 'React ve modern JavaScript frameworkleri ile kullanıcı arayüzü geliştirme', NOW(), NOW(), 'system', 'system'),
('Cloud Engineer', 'AWS, Azure ve GCP üzerinde cloud-native çözümler geliştirme', NOW(), NOW(), 'system', 'system'),
('Data Scientist', 'Makine öğrenmesi ve veri analizi modelleri geliştirme', NOW(), NOW(), 'system', 'system'),
('Mobile App Developer', 'Android (Kotlin) ve iOS (Swift) uygulama geliştirme', NOW(), NOW(), 'system', 'system');

-- Courses
INSERT INTO courses (title, image_src, image_alt, url, created_at, updated_at, created_by, updated_by) VALUES
('Java', '','','https://gelecegiyazanlar.turkcell.com.tr/egitimler/java','','','','',''),
('İleri Python', '','','https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-python','','','','',''),
('React', '','','https://gelecegiyazanlar.turkcell.com.tr/egitimler/react','','','','',''),
('Veri Manipülasyonu', '','','https://gelecegiyazanlar.turkcell.com.tr/egitimler/veri-manipulasyonu','','','','',''),
('İleri Java', '','','https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-java','','','','','');

--Blogs
INSERT INTO blogs (title,image_src, image_alt, url, created_at, updated_at, created_by, updated_by ) VALUES
('React.js ile Güvenli Yazılım Pratikleri', '','','https://gelecegiyazanlar.turkcell.com.tr/blog/reactjs-ile-guvenli-yazilim-pratikleri','','','','',''),
('Regex ile Gizli Bilgilerin Tespiti', '','','https://gelecegiyazanlar.turkcell.com.tr/blog/regex-ile-gizli-bilgilerin-tespiti','','','','',''),
('Web Yazılımına Nereden Başlanmalı?', '','','https://gelecegiyazanlar.turkcell.com.tr/blog/web-yazilimina-nereden-baslanmali','','','','',''),
('React JS için Redux Kurulumu ve Yönetimi', '','','https://gelecegiyazanlar.turkcell.com.tr/blog/react-js-icin-redux-kurulumu-ve-yonetimi','','','','',''),
('Pandas ile Veri Analizi', '','','https://gelecegiyazanlar.turkcell.com.tr/blog/pandas-ile-veri-analizi','','','','',''),