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
(1, 2), -- Java -> Spring Boot tag'i
(2, 5), -- İleri Python -> Data Science tag'i
(3, 3), -- React -> Frontend tag'i
(4, 5), -- Veri Manipülasyonu -> Data Science tag'i
(5, 1); -- İleri Java -> Java tag'i

-- blogs and tags
INSERT INTO blog_tags (blog_id, tag_id) VALUES
(1, 3), -- React.js Güvenli Yazılım Pratikleri -> Frontend tag'i
(2, 1), -- Regex -> Java tag'i (veya uygun olan)
(3, 3), -- Web Yazılımına Nereden Başlanmalı? -> Frontend tag'i
(4, 3), -- Redux Kurulumu -> Frontend tag'i
(5, 5); -- Pandas ile Veri Analizi -> Data Science tag'i

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
(1, 1), -- Java -> Yazılım Geliştirme
(2, 3), -- İleri Python -> Veri Bilimi
(3, 1), -- React -> Yazılım Geliştirme
(4, 3), -- Veri Manipülasyonu -> Veri Bilimi
(5, 1); -- İleri Java -> Yazılım Geliştirme

-- blogs and categories
INSERT INTO blog_categories (blog_id, category_id) VALUES
(1, 1), -- React.js blogu -> Yazılım Geliştirme
(2, 1), -- Regex blogu -> Yazılım Geliştirme
(3, 1), -- Web Yazılımı blogu -> Yazılım Geliştirme
(4, 1), -- Redux blogu -> Yazılım Geliştirme
(5, 3); -- Pandas blogu -> Veri Bilimi

-- jobs and categories
INSERT INTO job_categories (job_id, category_id) VALUES
(1, 1), -- Java Backend Developer -> Yazılım Geliştirme
(2, 1), -- Frontend Developer -> Yazılım Geliştirme
(3, 4), -- Cloud Engineer -> Bulut Bilişim
(4, 3), -- Data Scientist -> Veri Bilimi
(5, 2); -- Mobile App Developer -> Mobil Uygulama
