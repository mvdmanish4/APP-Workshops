db = connect("localhost:27017/APP19_Workshop5");
coll = db.driver;
coll.insert({
    "firstName" : "Axa",
    "middleName" : "Bexa",
    "lastName" : "Mexa",
    "emailId" : "axa.bexa@gmail.com",
    "password" : "abcerwrwrde321",
    "phoneNumber" : "+16345559606",
    "address1" : "543 Main Street",
    "address2" : null,
    "city": "Manytown",
    "state": "CA",
    "country" : "us",
    "postalCode" : "94045",
    "rating": NumberInt(3),
    "drivingLicenseNumber" : NumberInt(200),
    "dlIssuedState" : "CA"
});

coll.insert({
    "firstName" : "John",
    "middleName" : "Andrew",
    "lastName" : "Smith",
    "emailId" : "john.smith@gmail.com",
    "password" : "abcde321",
    "phoneNumber" : "+16505559606",
    "address1" : "123 Main Street",
    "address2" : null,
    "city": "Anytown",
    "state": "CA",
    "country" : "us",
    "postalCode" : "94035",
    "rating": NumberInt(4),
    "drivingLicenseNumber" : NumberInt(100),
    "dlIssuedState" : "CA"
});
