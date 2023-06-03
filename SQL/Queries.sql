USE hotel;

-- Write a query that returns a list of reservations that end in July 2023,
-- including the name of the guest, the room number(s), and the reservation dates.
SELECT name, roomNumber, startDate, endDate
FROM reservations
WHERE endDate <= '2023-07-31';

-- Write a query that returns a list of all reservations for rooms with a jacuzzi,
-- displaying the guest's name, the room number, and the dates of the reservation.
SELECT DISTINCT reservations.name, reservations.roomNumber, reservations.startDate, reservations.endDate
FROM rooms, roomAmenities, reservations
WHERE rooms.roomNumber = roomAmenities.roomNumber AND
      roomAmenities.amenity="Jacuzzi" AND
      rooms.roomNumber = reservations.roomNumber;

-- Write a query that returns all the rooms reserved for a specific guest,
-- including the guest's name, the room(s) reserved, the starting date of the reservation,
-- and how many people were included in the reservation. (Choose a guest's name from the existing data.)
SELECT name, roomNumber, startDate, (adults + children) as totalPeople
FROM reservations
WHERE name="Maritza Tilton";

-- Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation.
-- The results should include all rooms, whether or not there is a reservation associated with the room.
SELECT rooms.roomNumber, name, startDate, endDate, total
FROM reservations RIGHT JOIN rooms
ON reservations.roomNumber = rooms.roomNumber;

-- Write a query that returns all the rooms accommodating at least three guests
-- and that are reserved on any date in April 2023.
SELECT roomNumber
FROM reservations
WHERE (adults + children >= 3) AND
      ((startDate >= '2023-04-01' AND startDate <= '2023-04-30') OR
      (endDate >= '2023-04-01' AND endDate <= '2023-04-30'));

-- Write a query that returns a list of all guest names and the number of reservations per guest,
-- sorted starting with the guest with the most reservations and then by the guest's last name.
SELECT name, COUNT(name) as numberOfReservations
FROM reservations
GROUP BY name
ORDER BY numberOfReservations DESC, name;

-- Write a query that displays the name, address, and phone number of a guest based on their phone number.
-- (Choose a phone number from the existing data.)
SELECT name, address, phone
FROM guests
WHERE phone="(446) 351-6860";



