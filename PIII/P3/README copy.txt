When the you first run the app:

The app will read:
Client information from Clients.csv 

Admin information from Admins.csv 

Password for both admin and client in Passwords.csv(see the format below). 

Also flights information is stored in Workbook.csv

Passwords.csv, Clients.csv, Admins.csv and Workbook.csv should be pushed into data/data/csc207.group0388.pii/app_data

When an admin uploads the data, the admin should give the name of file which they want to upload in 
data/data/csc207.group0388.piii/app_userdata

Once an admin uploads the client.  It is necessary for them to upload the password file for those clients. (Otherwise they won’t be able to log in.)

For password file we use email as username.

Password Format:
email,password

CAUTION:
You are not allowed to register as a admin, the only way to add a admin is put the admin’s
information in Admins.csv, password in Passwords.csv, and both files should be put in to
data/data/csc207.group0388.pii/app_data.