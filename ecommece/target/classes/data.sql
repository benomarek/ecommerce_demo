INSERT INTO animal_category(name) VALUES ('dogs');
INSERT INTO animal_category(name) VALUES ('cats');
INSERT INTO animal_category(name) VALUES ('other');

INSERT INTO product(name,price, description,animal_category) VALUES ('Fitmin For Life Lamb & Rice 15 kg', 30.40, 'Vyvážené krmivo pre psov všetkých plemien, s čerstvým jahňacím mäsom, hypoalergennna receptúra bez pšenice.', 'dogs');
INSERT INTO product(name,price, description,animal_category) VALUES ('Purina Pro Plan Large Adult Athletic Sensitive Digestion', 47.80, 'Granulované krmivo pre dospelé psy veľkých plemien atletického typu s citlivým trávením s vysokým obsahom', 'dogs');
INSERT INTO product(name,price, description,animal_category) VALUES ('Pedigree Adult s hovädzím a hydinovým mäsom 15 kg', 16.01, 'Kompletné krmivo pre dospelé psy všetkých plemien v bežnej záťaži s hovädzím a hydinovým mäsom.', 'dogs');
INSERT INTO product(name,price, description,animal_category) VALUES ('Friskies Adult balance 15 kg', 25.00, 'Kompletné a vyvážené krmivo so 100% živín, ktoré váš dospelý pes potrebuje každý deň.', 'dogs');
INSERT INTO product(name,price, description,animal_category) VALUES ('Brit Care Adult Small Breed Lamb & Rice 7,5kg', 27.00, 'Hypoalergénna receptúra jahňacie s ryžou pre dospelých psov malých a trpasličích plemien (1–10 kg).', 'dogs');

INSERT INTO product(name,price, description,animal_category) VALUES ('Whiskas s hovädzím mäsom 14 kg', 20.83, 'Plnené vankúšiky s hovädzím mäsom pre mačky.', 'cats');
INSERT INTO product(name,price, description,animal_category) VALUES ('Royal Canin Fit 10 kg', 55.00, 'Granule zachovávajú optimálnu váhu dospelých mačiek vďaka zníženému obsahu tuku. Vláknina napomáha znížiť...', 'cats');
INSERT INTO product(name,price, description,animal_category) VALUES ('Royal Canin Sterilised 10 kg', 55.00, 'Krmivo vyvinuté pre udržanie optimálnej váhy a zachovanie zdravého močového systému kastrovaných mačiek.', 'cats');
INSERT INTO product(name,price, description,animal_category) VALUES ('Purina Cat Sterilised Turkey 10 kg', 61.70, 'Optimálna výživa a posilnená ochrana pre kastrované a sterilizované mačky s vysokým podielom kuracieho mäsa a...', 'cats');
INSERT INTO product(name,price, description,animal_category) VALUES ('WELLNESS-CORE Kitten Turkey with Salmon Recipe 1,75 kg', 17.00, 'Kompletné krmivo pre mačiatka obsahuje zeleninu a čerstvé morčacie mäso s lososom. Podporuje energiu a...', 'cats');

INSERT INTO product(name,price, description,animal_category) VALUES ('Akinu Sippy deluxe pre andulky 7 x 500g', 8.60, 'Kompletná kŕmna zmes zo starostlivo vybraných surovín pre andulky. Výhodné balenie 7×500g.', 'other');
INSERT INTO product(name,price, description,animal_category) VALUES ('Versele Laga African Parrot Loro Parque Mix - prémiová', 10.90, 'Kompletná prémiová zmes pre veľké africké papagáje, napr. Papagáje žako, senegalské, konžske, atď...', 'other');
INSERT INTO product(name,price, description,animal_category) VALUES ('Versele Laga Canary - univerzálna zmes pre kanáriky', 13.00, 'Kompletná kŕmna zmes pre kanáriky..', 'other');

INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/36001055/550/550',1);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',2);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',3);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',4);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',5);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',6);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',7);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',9);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',10);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',11);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',12);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',13);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',1);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',1);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',4);
INSERT INTO gallery_url(url, product_id) VALUES ('https://www.mall.cz/i/38763331/2000/2000',5);
commit;