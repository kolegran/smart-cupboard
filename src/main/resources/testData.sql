DROP SCHEMA PUBLIC CASCADE;
CREATE SCHEMA PUBLIC;

INSERT INTO cupboard (title) VALUES
('physics laboratory'),
('chemistry laboratory'),
('drug laboratory');

INSERT INTO shelf (title, cupboard_id) VALUES
('solutions', 2),
('alloys', 2),
('metals', 2),
('mechanical mixtures', 2),
('organic', 2);

INSERT INTO sector (title, shelf_id) VALUES
('carbon dioxide', 1),
('sodium chloride', 1),
('sucrose', 1),
('electrolyte', 1);

INSERT INTO sector (title, shelf_id) VALUES
('rose metal', 2),
('chromium hydride', 2),
('nickel silver', 2),
('nordic gold', 2);

INSERT INTO sector (title, shelf_id) VALUES
('palladium', 3),
('gold', 3),
('silver', 3),
('platinum', 3);

INSERT INTO sector (title, shelf_id) VALUES
('fog', 4),
('aerogel', 4),
('hand cream', 4),
('ice cloud', 4);

INSERT INTO sector (title, shelf_id) VALUES
('silver bromide', 5),
('ethenol', 5),
('acetone', 5),
('cyanogen', 5);

INSERT INTO reader (id, title, sector_id) VALUES
('RC-522-1', 'RC-522-1-reader', 1),
('RC-522-2', 'RC-522-2-reader', 2),
('RC-522-3', 'RC-522-3-reader', 3),
('RC-522-4', 'RC-522-4-reader', 4);

INSERT INTO reader (id, title, sector_id) VALUES
('RC-522-5', 'RC-522-5-reader', 5),
('RC-522-6', 'RC-522-6-reader', 6),
('RC-522-7', 'RC-522-7-reader', 7),
('RC-522-8', 'RC-522-8-reader', 8);

INSERT INTO reader (id, title, sector_id) VALUES
('RC-522-9', 'RC-522-9-reader', 9),
('RC-522-10', 'RC-522-10-reader', 10),
('RC-522-11', 'RC-522-11-reader', 11),
('RC-522-12', 'RC-522-12-reader', 12);

INSERT INTO reader (id, title, sector_id) VALUES
('RC-522-13', 'RC-522-13-reader', 13),
('RC-522-14', 'RC-522-14-reader', 14),
('RC-522-15', 'RC-522-15-reader', 15),
('RC-522-16', 'RC-522-16-reader', 16);

INSERT INTO reader (id, title, sector_id) VALUES
('RC-522-17', 'RC-522-17-reader', 17),
('RC-522-18', 'RC-522-18-reader', 18),
('RC-522-19', 'RC-522-19-reader', 19),
('RC-522-20', 'RC-522-20-reader', 20);

INSERT INTO device (mac_address, created_at, title, uuid, shelf_id) VALUES
('80:8D:8A:8E:BE:88', '2019-03-08 08:01:25','esp-80', '6e3974b7-5032-46d6-a33d-ac74a65fc694', 1),
('70:7D:7A:7E:CE:87', '2019-03-09 07:05:12','esp-70', 'b6ccab00-b937-4551-bed7-3aba96fa3b3b', 2),
('60:6D:6A:6E:DE:86', '2019-03-10 04:08:32','esp-60', 'f5cd76fd-42ba-4fcf-a0e6-84959b65507f', 3),
('50:5D:5A:5E:EE:85', '2019-03-11 01:10:13','esp-50', '9a900721-b16e-4e21-b034-9282956a4491', 4),
('40:4D:4A:4E:FE:84', '2019-03-12 05:22:05','esp-40', 'c4cafbf5-07bd-4b0a-856b-f582069b9518', 5);

INSERT INTO item (created_at, rfid, status, title) VALUES
('2019-03-08 08:01:25', 'A00152045B', 'TAKEN', 'HNO2'),
('2019-03-08 20:07:13', 'EB2561739S', 'TAKEN', 'H2O'),
('2019-03-09 01:15:14', 'N45651212E', 'TAKEN', 'H2CO3'),
('2019-03-13 07:24:05', '40DFG67182', 'TAKEN', 'HF'),
('2019-03-16 09:13:56', 'HG6700011B', 'TAKEN', 'HCl'),
('2019-03-20 13:18:26', 'Y0012F7878', 'TAKEN', 'NO2'),
('2019-03-21 23:45:41', 'LJ2361670C', 'TAKEN', 'SO4');

INSERT INTO users (email, first_name, last_name, password) VALUES
('ritchie@gmail.com', 'Dennis', 'Ritchie', ''),
('hatenvidia@gmail.com', 'Linus', 'Torvalds', ''),
('goslink@gmail.com', 'James', 'Goslink', '');