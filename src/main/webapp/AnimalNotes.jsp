<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Animal Shelter</title>
    <link rel="stylesheet" href="css/AnimalShelterCSS.css" />
</head>
<body>
<h1 class="h1-style">Animal Shelter</h1>
<div class="nav-links">
    <ul>
        <li><a href="ListAnimal.jsp" target="_self">List Animals</a></li>

        <li><a href="AddAnimal.jsp" target="_parent">Add an Animal</a></li>
    </ul>
</div>

<br />

<h2>Animal Notes</h2>

<article>
    <div>
    <img src="" />
    </div>
    <div>
        <ul>
            <h3><a href="AddAnimal.jsp">Bob</a></h3>
            <li><strong>Type</strong>: Cat</li>
            <li><strong>Breed</strong>: Tabby</li>
            <li><strong>Description</strong>: Big fat and fuzzy</li>
        </ul>
    </div>
</article>

<div class="notes">
    Date    note
    <br />8/29/16 Went to visit vet <button href="AnimalNotes.jsp">Delete Note</button>
    <br />8/30/16 Only eat filet mignon <button href="AnimalNotes.jsp">Delete Note</button>
</div>

<div>
    <form action="AnimalNotes.jsp" method="post" enctype="multipart/form-data">

        <label>Add a note:</label>
        <br />
        <textarea name="description" maxlength="500" rows="10" required></textarea>
        <br />
        <button type="submit">Add Note</button>

    </form>
</div>

<br/>


</body>
</html>