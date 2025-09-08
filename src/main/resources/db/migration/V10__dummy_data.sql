-- TAGS
INSERT INTO tags (name, created_by, updated_by) VALUES
('Java', 'system', 'system'),
('Spring Boot', 'system', 'system'),
('Python', 'system', 'system'),
('JavaScript', 'system', 'system'),
('Cloud', 'system', 'system'),
('Data Science', 'system', 'system');
('React', 'system', 'system');
('Veri Görselleştirme', 'system', 'system');

-- CATEGORIES
INSERT INTO categories (name, created_by, updated_by) VALUES
('Yazılım Geliştirme', 'system', 'system'),
('Mobil Uygulama', 'system', 'system'),
('Veri Bilimi', 'system', 'system'),
('Bulut Bilişim', 'system', 'system'),
('Kariyer', 'system', 'system');
('Backend', 'system', 'system');
('Frontend', 'system', 'system');
('Web Programlama', 'system', 'system')

-- JOBS
INSERT INTO jobs (title, description, created_at, updated_at, created_by, updated_by) VALUES
('Java Backend Developer', 'Spring Boot, REST API ve microservice mimarisi üzerine backend geliştirme', NOW(), NOW(), 'system', 'system'),
('Frontend Developer', 'React ve modern JavaScript frameworkleri ile kullanıcı arayüzü geliştirme', NOW(), NOW(), 'system', 'system'),
('Cloud Engineer', 'AWS, Azure ve GCP üzerinde cloud-native çözümler geliştirme', NOW(), NOW(), 'system', 'system'),
('Data Scientist', 'Makine öğrenmesi ve veri analizi modelleri geliştirme', NOW(), NOW(), 'system', 'system'),
('Mobile App Developer', 'Android (Kotlin) ve iOS (Swift) uygulama geliştirme', NOW(), NOW(), 'system', 'system');

-- COURSES
INSERT INTO courses (title, image_src, image_alt, url, created_at, updated_at, created_by, updated_by) VALUES
('Java', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/egitimler/java', NOW(), NOW(), 'system', 'system'),
('İleri Python', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-python', NOW(), NOW(), 'system', 'system'),
('React', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/egitimler/react', NOW(), NOW(), 'system', 'system'),
('Veri Manipülasyonu', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/egitimler/veri-manipulasyonu', NOW(), NOW(), 'system', 'system'),
('İleri Java', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/egitimler/ileri-java', NOW(), NOW(), 'system', 'system');

-- BLOGS
INSERT INTO blogs (title, image_src, image_alt, url, created_at, updated_at, created_by, updated_by) VALUES
('React.js ile Güvenli Yazılım Pratikleri', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/blog/reactjs-ile-guvenli-yazilim-pratikleri', NOW(), NOW(), 'system', 'system'),
('Regex ile Gizli Bilgilerin Tespiti', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/blog/regex-ile-gizli-bilgilerin-tespiti', NOW(), NOW(), 'system', 'system'),
('Web Yazılımına Nereden Başlanmalı?', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/blog/web-yazilimina-nereden-baslanmali', NOW(), NOW(), 'system', 'system'),
('React JS için Redux Kurulumu ve Yönetimi', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/blog/react-js-icin-redux-kurulumu-ve-yonetimi', NOW(), NOW(), 'system', 'system'),
('Pandas ile Veri Analizi', '', '', 'https://gelecegiyazanlar.turkcell.com.tr/blog/pandas-ile-veri-analizi', NOW(), NOW(), 'system', 'system');

-- CAREER PATHS
INSERT INTO career_paths (name, description, created_by, updated_by, created_at, updated_at) VALUES
('Java Backend Developer', 'Java ve Spring Boot ile backend geliştirme için yol haritası', 'system', 'system', NOW(), NOW());

-- CAREER PATH COURSES
INSERT INTO career_path_courses (career_path_id, course_id, order_no) VALUES
(1, 1, 1), -- Java
(1, 5, 2), -- İleri Java
(1, 3, 3); -- React

-- courses and tags
INSERT INTO course_tags (course_id, tag_id) VALUES
(1, 1), -- Java -> Java tag'i
(2, 3), -- İleri Python -> Python tag'i
(2, 5), -- İleri Python -> Data Science tag'i
(2, 5), -- İleri Python -> Veri Görselleştirme tag'i
(5, 1), -- İleri Java -> Java tag'i
(3, 4), -- React -> JS tag'i
(3, 7), -- React -> React tag'i
(4, 6), -- Veri Manipülasyonu -> Data Science tag'i
(4, 8), -- Veri Manipülasyonu -> Data Science tag'i
(5, 1); -- İleri Java -> Java tag'i
(5, 2); -- İleri Java -> Spring Boot tag'i

-- blogs and tags
INSERT INTO blog_tags (blog_id, tag_id) VALUES
(1, 7), -- React.js Güvenli Yazılım Pratikleri -> React tag'i
(1, 4), -- React.js Güvenli Yazılım Pratikleri -> JS tag'i
(2, 6), -- Regex -> Veri tag'i
(3, 1), -- Web yazılımına Nereden Başlanmalı?-> Java tag'i
(3, 2), -- Web yazılımına Nereden Başlanmalı?-> Java tag'i
(3, 4), -- Web yazılımına Nereden Başlanmalı? -> JS tag'i
(4, 7), -- Redux Kurulumu -> React tag'i
(5, 6); -- Pandas ile Veri Analizi -> Data Science tag'i

-- jobs and tags
INSERT INTO job_tags (job_id, tag_id) VALUES
(1, 1), -- Java Backend Developer -> Java tag'i
(1, 2), -- Java Backend Developer -> Spring Boot tag'i
(2, 3), -- Frontend Developer -> Frontend tag'i
(3, 4), -- Cloud Engineer -> Cloud tag'i
(4, 5), -- Data Scientist -> Data Science tag'i
(5, 1); -- Mobile App Developer -> Java tag'i (veya uygun olan)

-- courses and categories
INSERT INTO course_categories (course_id, category_id) VALUES
(1, 1), -- Java -> yazılım geliştirme
(1, 2), -- Java -> mobil uygulama
(1, 6), -- Java -> backend
(2, 3), -- İleri Python -> veri bilimi
(2, 7), -- İleri Python -> frontend
(3, 7), -- React -> Frontend
(4, 3), -- Veri Manipülasyonu -> veri bilimi
(5, 1); -- İleri Java -> yazılım geliştirme
(5, 2); -- İleri Java -> mobil uygulama
(5, 6); -- İleri Java -> backend

-- blogs and categories
INSERT INTO blog_categories (blog_id, category_id) VALUES
(1, 7), -- React.js blogu -> frontend
(1, 8), -- React.js blogu -> Web programlama
(2, 1), -- Regex blogu -> Yazılım Geliştirme
(3, 8), -- Web Yazılımı blogu -> web prog
(4, 7), -- Redux blogu -> frontend
(5, 3); -- Pandas blogu -> Veri Bilimi

-- jobs and categories
INSERT INTO job_categories (job_id, category_id) VALUES
(1, 1), -- Java Backend Developer -> Yazılım Geliştirme
(2, 1), -- Frontend Developer -> Yazılım Geliştirme
(3, 4), -- Cloud Engineer -> Bulut Bilişim
(4, 3), -- Data Scientist -> Veri Bilimi
(5, 2); -- Mobile App Developer -> Mobil Uygulama
