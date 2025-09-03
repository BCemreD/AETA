-- TAGS
INSERT INTO tags (name, created_by, updated_by) VALUES
('Java', 'system', 'system'),
('Spring Boot', 'system', 'system'),
('Frontend', 'system', 'system'),
('Cloud', 'system', 'system'),
('Data Science', 'system', 'system');

-- CATEGORIES
INSERT INTO categories (name, created_by, updated_by) VALUES
('Yazılım Geliştirme', 'system', 'system'),
('Mobil Uygulama', 'system', 'system'),
('Veri Bilimi', 'system', 'system'),
('Bulut Bilişim', 'system', 'system'),
('Kariyer', 'system', 'system');

-- JOBS
INSERT INTO jobs (title, description, created_at, updated_at, created_by, updated_by) VALUES
('Java Backend Developer', 'Spring Boot, REST API ve microservice mimarisi üzerine backend geliştirme', NOW(), NOW(), 'system', 'system'),
('Frontend Developer', 'React ve modern JavaScript frameworkleri ile kullanıcı arayüzü geliştirme', NOW(), NOW(), 'system', 'system'),
('Cloud Engineer', 'AWS, Azure ve GCP üzerinde cloud-native çözümler geliştirme', NOW(), NOW(), 'system', 'system'),
('Data Scientist', 'Makine öğrenmesi ve veri analizi modelleri geliştirme', NOW(), NOW(), 'system', 'system'),
('Mobile App Developer', 'Android (Kotlin) ve iOS (Swift) uygulama geliştirme', NOW(), NOW(), 'system', 'system');

-- COURSES
INSERT INTO courses (title, image_src, image_alt, url, created_at, updated_at, created_by, updated_by) VALUES
('Java', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/egitimler/java](https://gelecegiyazanlar.turkcell.com.tr/egitimler/java)', NOW(), NOW(), 'system', 'system'),
('İleri Python', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-python](https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-python)', NOW(), NOW(), 'system', 'system'),
('React', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/egitimler/react](https://gelecegiyazanlar.turkcell.com.tr/egitimler/react)', NOW(), NOW(), 'system', 'system'),
('Veri Manipülasyonu', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/egitimler/veri-manipulasyonu](https://gelecegiyazanlar.turkcell.com.tr/egitimler/veri-manipulasyonu)', NOW(), NOW(), 'system', 'system'),
('İleri Java', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-java](https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-java)', NOW(), NOW(), 'system', 'system');

-- BLOGS
INSERT INTO blogs (title, image_src, image_alt, url, created_at, updated_at, created_by, updated_by) VALUES
('React.js ile Güvenli Yazılım Pratikleri', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/blog/reactjs-ile-guvenli-yazilim-pratikleri](https://gelecegiyazanlar.turkcell.com.tr/blog/reactjs-ile-guvenli-yazilim-pratikleri)', NOW(), NOW(), 'system', 'system'),
('Regex ile Gizli Bilgilerin Tespiti', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/blog/regex-ile-gizli-bilgilerin-tespiti](https://gelecegiyazanlar.turkcell.com.tr/blog/regex-ile-gizli-bilgilerin-tespiti)', NOW(), NOW(), 'system', 'system'),
('Web Yazılımına Nereden Başlanmalı?', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/blog/web-yazilimina-nereden-baslanmali](https://gelecegiyazanlar.turkcell.com.tr/blog/web-yazilimina-nereden-baslanmali)', NOW(), NOW(), 'system', 'system'),
('React JS için Redux Kurulumu ve Yönetimi', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/blog/react-js-icin-redux-kurulumu-ve-yonetimi](https://gelecegiyazanlar.turkcell.com.tr/blog/react-js-icin-redux-kurulumu-ve-yonetimi)', NOW(), NOW(), 'system', 'system'),
('Pandas ile Veri Analizi', '', '', '[https://gelecegiyazanlar.turkcell.com.tr/blog/pandas-ile-veri-analizi](https://gelecegiyazanlar.turkcell.com.tr/blog/pandas-ile-veri-analizi)', NOW(), NOW(), 'system', 'system');

-- CAREER PATHS
INSERT INTO career_paths (name, description, created_by, updated_by, created_at, updated_at) VALUES
('Java Backend Developer', 'Java ve Spring Boot ile backend geliştirme için yol haritası', 'system', 'system', NOW(), NOW());

-- CAREER PATH COURSES
INSERT INTO career_path_courses (career_path_id, course_id, order_no) VALUES
(1, 1, 1), -- Java
(1, 5, 2), -- İleri Java
(1, 3, 3); -- React