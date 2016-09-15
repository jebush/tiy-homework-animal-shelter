<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animal Shelter</title>
    <link rel="stylesheet" href="../css/AnimalShelterCSS.css" />
</head>
<body>
<h1 class="h1-style">Animal Shelter</h1>
<div class="nav-links">
    <ul>
        <li><a href="ListAnimal.jsp" target="_self">List Animals</a></li>

        <li><a href="AddAnimal.jsp" target="_parent">Add an Animal</a></li>

        <li><a href="AnimalNotes.jsp" target="_parent">Animal Notes</a></li>
    </ul>
</div>

<br />

<h2>Add / Edit an Animals</h2>
<div>
    <form action="https://tiy-test-form-target.herokuapp.com/post" method="post" enctype="multipart/form-data">
        <p>* indicates a required field</p>

        <label>Name*:</label>
        <input name="name" type="text" placeholder="Enter Name" required>

        <br />
        <label>Species*:</label>
        <select id = "species">
            <option value = "1">Cat</option>
            <option value = "2">Bird</option>
            <option value = "3">Dog</option>
            <option value = "4">Duck</option>
        </select>

        <br />

        <label>Breed:</label>
        <input name="breed" type="text" placeholder="Enter Breed" required>

        <br />
        <label>Description*:</label>
        <br />
        <textarea name="description" maxlength="500" rows="10" required></textarea>

        <br />

        <label>Photo:</label>
        <input name="photo" type="file">

        <br />

        <button type="submit">Save Animal</button>

    </form>
</div>

<br/>

<div>


</div>

</body>
</html>