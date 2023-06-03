USE hotel;

INSERT INTO roomTypes VALUES ("DOUBLE", 2, 4, 174.99, 10);
INSERT INTO roomTypes VALUES ("SINGLE", 2, 2, 149.99, 0);
INSERT INTO roomTypes VALUES ("SUITE", 3, 8, 399.99, 20);

INSERT INTO rooms VALUES (201, "DOUBLE");
INSERT INTO rooms VALUES (202, "DOUBLE");
INSERT INTO rooms VALUES (203, "DOUBLE");
INSERT INTO rooms VALUES (204, "DOUBLE");
INSERT INTO rooms VALUES (205, "SINGLE");
INSERT INTO rooms VALUES (206, "SINGLE");
INSERT INTO rooms VALUES (207, "SINGLE");
INSERT INTO rooms VALUES (208, "SINGLE");
INSERT INTO rooms VALUES (301, "DOUBLE");
INSERT INTO rooms VALUES (302, "DOUBLE");
INSERT INTO rooms VALUES (303, "DOUBLE");
INSERT INTO rooms VALUES (304, "DOUBLE");
INSERT INTO rooms VALUES (305, "SINGLE");
INSERT INTO rooms VALUES (306, "SINGLE");
INSERT INTO rooms VALUES (307, "SINGLE");
INSERT INTO rooms VALUES (308, "SINGLE");
INSERT INTO rooms VALUES (401, "SUITE");
INSERT INTO rooms VALUES (402, "SUITE");

INSERT INTO amenities VALUES ("Microwave", 0);
INSERT INTO amenities VALUES ("Refrigerator", 0);
INSERT INTO amenities VALUES ("Jacuzzi", 0);
INSERT INTO amenities VALUES ("Oven", 0);
INSERT INTO amenities VALUES ("ADA", 0);

INSERT INTO roomAmenities VALUES (201, "Microwave");
INSERT INTO roomAmenities VALUES (201, "Jacuzzi");
INSERT INTO roomAmenities VALUES (202, "Refrigerator");
INSERT INTO roomAmenities VALUES (202, "ADA");
INSERT INTO roomAmenities VALUES (203, "Microwave");
INSERT INTO roomAmenities VALUES (203, "Jacuzzi");
INSERT INTO roomAmenities VALUES (204, "Refrigerator");
INSERT INTO roomAmenities VALUES (204, "ADA");
INSERT INTO roomAmenities VALUES (205, "Microwave");
INSERT INTO roomAmenities VALUES (205, "Jacuzzi");
INSERT INTO roomAmenities VALUES (205, "Refrigerator");
INSERT INTO roomAmenities VALUES (206, "Refrigerator");
INSERT INTO roomAmenities VALUES (206, "Microwave");
INSERT INTO roomAmenities VALUES (206, "ADA");
INSERT INTO roomAmenities VALUES (207, "Microwave");
INSERT INTO roomAmenities VALUES (207, "Jacuzzi");
INSERT INTO roomAmenities VALUES (207, "Refrigerator");
INSERT INTO roomAmenities VALUES (208, "Refrigerator");
INSERT INTO roomAmenities VALUES (208, "ADA");
INSERT INTO roomAmenities VALUES (208, "Microwave");
INSERT INTO roomAmenities VALUES (301, "Microwave");
INSERT INTO roomAmenities VALUES (301, "Jacuzzi");
INSERT INTO roomAmenities VALUES (302, "Refrigerator");
INSERT INTO roomAmenities VALUES (302, "ADA");
INSERT INTO roomAmenities VALUES (303, "Microwave");
INSERT INTO roomAmenities VALUES (303, "Jacuzzi");
INSERT INTO roomAmenities VALUES (304, "Refrigerator");
INSERT INTO roomAmenities VALUES (304, "ADA");
INSERT INTO roomAmenities VALUES (305, "Microwave");
INSERT INTO roomAmenities VALUES (305, "Jacuzzi");
INSERT INTO roomAmenities VALUES (305, "Refrigerator");
INSERT INTO roomAmenities VALUES (306, "Refrigerator");
INSERT INTO roomAmenities VALUES (306, "ADA");
INSERT INTO roomAmenities VALUES (306, "Microwave");
INSERT INTO roomAmenities VALUES (307, "Microwave");
INSERT INTO roomAmenities VALUES (307, "Jacuzzi");
INSERT INTO roomAmenities VALUES (307, "Refrigerator");
INSERT INTO roomAmenities VALUES (308, "Refrigerator");
INSERT INTO roomAmenities VALUES (308, "Microwave");
INSERT INTO roomAmenities VALUES (308, "ADA");
INSERT INTO roomAmenities VALUES (401, "Microwave");
INSERT INTO roomAmenities VALUES (401, "Refrigerator");
INSERT INTO roomAmenities VALUES (401, "Oven");
INSERT INTO roomAmenities VALUES (401, "ADA");
INSERT INTO roomAmenities VALUES (402, "Microwave");
INSERT INTO roomAmenities VALUES (402, "Refrigerator");
INSERT INTO roomAmenities VALUES (402, "Oven");
INSERT INTO roomAmenities VALUES (402, "ADA");

INSERT INTO guests VALUES ("Mack Simmer", "379 Old Shore Street", "Council Bluffs", "IA", 51501, "(291) 553-0508");
INSERT INTO guests VALUES ("Bettyann Seery", "750 Wintergreen Dr.", "Wasilla", "AK", 99654, "(478) 277-9632");
INSERT INTO guests VALUES ("Duane Cullison", "9662 Foxrun Lane", "Harlingen", "TX", 78552, "(308) 494-0198");
INSERT INTO guests VALUES ("Karie Yang", "9378 W. Augusta Ave.", "West Deptford", "NJ", 8096, "(214) 730-0298");
INSERT INTO guests VALUES ("Aurore Lipton", "762 Wild Rose Street", "Saginaw", "MI", 48601, "(377) 507-0974");
INSERT INTO guests VALUES ("Zachery Luechtefeld", "7 Poplar Dr.", "Arvada", "CO", 80003, "(814) 485-2615");
INSERT INTO guests VALUES ("Jeremiah Pendergrass", "70 Oakwood St.", "Zion", "IL", 60099, "(279) 491-0960");
INSERT INTO guests VALUES ("Walter Holaway", "7556 Arrowhead St.", "Cumberland", "RI", 2864, "(446) 396-6785");
INSERT INTO guests VALUES ("Wilfred Vise", "77 West Surrey Street", "Oswego", "NY", 13126, "(834) 727-1001");
INSERT INTO guests VALUES ("Maritza Tilton", "939 Linda Rd.", "Burke", "VA", 22015, "(446) 351-6860");
INSERT INTO guests VALUES ("Joleen Tison", "87 Queen St.", "Drexel Hill", "PA", 19026, "(231) 893-2755");

INSERT INTO reservations VALUES (308, "Mack Simmer", 1, 0, "2023-02-02", "2023-02-04", 299.98);
INSERT INTO reservations VALUES (203, "Bettyann Seery", 2, 1, "2023-02-05", "2023-02-10", 999.95);
INSERT INTO reservations VALUES (305, "Duane Cullison", 2, 0, "2023-02-22", "2023-02-24", 349.98);
INSERT INTO reservations VALUES (201, "Karie Yang", 2, 2, "2023-03-06", "2023-03-07", 199.99);
INSERT INTO reservations VALUES (302, "Aurore Lipton", 3, 0, "2023-03-18", "2023-03-23", 924.95);
INSERT INTO reservations VALUES (202, "Zachery Luechtefeld", 2, 2, "2023-03-29", "2023-03-31", 349.98);
INSERT INTO reservations VALUES (304, "Jeremiah Pendergrass", 2, 0, "2023-03-31", "2023-04-05", 874.95);
INSERT INTO reservations VALUES (301, "Walter Holaway", 1, 0, "2023-04-09", "2023-04-13", 799.96);
INSERT INTO reservations VALUES (207, "Wilfred Vise", 1, 1, "2023-04-23", "2023-04-24", 174.99);
INSERT INTO reservations VALUES (401, "Maritza Tilton", 2, 4, "2023-05-30", "2023-06-02", 1199.97);
INSERT INTO reservations VALUES (206, "Joleen Tison", 2, 0, "2023-06-10", "2023-06-14", 599.96);
INSERT INTO reservations VALUES (208, "Joleen Tison", 1, 0, "2023-06-10", "2023-06-14", 599.96);
INSERT INTO reservations VALUES (304, "Aurore Lipton", 3, 0, "2023-06-17", "2023-06-18", 184.99);
INSERT INTO reservations VALUES (204, "Walter Holaway", 3, 1, "2023-07-13", "2023-07-14", 184.99);
INSERT INTO reservations VALUES (401, "Wilfred Vise", 4, 2, "2023-07-18", "2023-07-21", 1259.97);
INSERT INTO reservations VALUES (303, "Bettyann Seery", 2, 1, "2023-07-28", "2023-07-29", 199.99);
INSERT INTO reservations VALUES (305, "Bettyann Seery", 1, 0, "2023-08-30", "2023-09-01", 349.98);
INSERT INTO reservations VALUES (208, "Mack Simmer", 2, 0, "2023-09-16", "2023-09-17", 149.99);
INSERT INTO reservations VALUES (203, "Karie Yang", 2, 2, "2023-09-13", "2023-09-15", 399.98);
INSERT INTO reservations VALUES (401, "Duane Cullison", 2, 2, "2023-11-22", "2023-11-25", 1199.97);
INSERT INTO reservations VALUES (206, "Mack Simmer", 2, 0, "2023-11-22", "2023-11-25", 449.97);
INSERT INTO reservations VALUES (301, "Mack Simmer", 2, 2, "2023-11-22", "2023-11-25", 599.97);
INSERT INTO reservations VALUES (302, "Maritza Tilton", 2, 0, "2023-12-24", "2023-12-28", 699.96);



