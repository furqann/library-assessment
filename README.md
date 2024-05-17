# library-assessment

## Requirements
- Java 21
- Maven 3.9.*
- PostgreSQL 15+
- Run the command `mvn clean install` to compile and generate jar file.

## How to run using IDE
- Set environment variables

|key| value                                              |
|---|----------------------------------------------------|
|db_url| jdbc:postgresql://{ADDRESS}:{PORT}/{DATABASE_NAME} |
|db_user| DATABASE_USERNAME                                  |
|db_pass| DATABASE_PASSWORD                                  |

## How to run using docker
- Meet all the requirements
- Run the command `mvn clean install` to compile and generate jar file.
- Run in the root folder `docker compose up -d`

## API Details

Base url `http://localhost:8090/api/v1/library`

> #### Get All Books
###### Request
`GET [BASE_URL]/books/all`
###### Response
Code: `200`\
Body: 
```json
[
	{
		"id": 1,
		"title": "5 AM Club",
		"author": "Robert Sharma",
		"isbn": "123-456-789",
		"available": false
	}
]
```

> #### Register Book
###### Request
`POST [BASE_URL]/books/register`

__Body__ 
```json
{
	"title": "5 AM Club",
	"author": "Robert Sharma",
	"isbn": "123-456-789"
}
```
###### Response
Code: 201\
Body: 
```json
{
	"id": 1,
	"title": "5 AM Club",
	"author": "Robert Sharma",
	"isbn": "123-456-789",
	"available": true
}
```

>#### Register Borrower
###### Request
`POST [BASE_URL]/borrower/register`

__Body:__
```json
{
	"name": "Ahmad",
	"email":"test@test.com"
}
```
###### Response
Code: 200\
Body:
```json
{
	"id": 1,
	"name": "Ahmad",
	"email": "test@test.com"
}
```
> #### Return Book
###### Request
`POST [BASE_URL]/return/books/{bookId}/borrowers/{borrowerId}`

|Variable|value|
|--------|-----|
|bookId| 1     |
|borrowerId|1 |
###### Response
```json
{
  "message": "Book is successfully returned"
}
```

> #### Borrow Book
###### Request
`POST [BASE_URL]/borrow/books/{bookId}/borrowers/{borrowerId}`


|Variable|value|
|--------|-----|
|bookId| 1     |
|borrowerId|1 |
###### Response
```json
{
	"message": "Successfully borrowed a book"
}
```