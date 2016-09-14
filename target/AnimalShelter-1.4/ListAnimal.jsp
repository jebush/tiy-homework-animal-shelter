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

        <li><a href="AnimalNotes.jsp" target="_parent">Animal Notes</a></li>
    </ul>
</div>

<br />


<h2>List Animals</h2>
<div>
    <form id="searchForm" action="https://tiy-test-form-target.herokuapp.com/post" method="post" enctype="multipart/form-data">
        <p>Search for an animal:</p>
        <input name="name" type="text" placeholder="Name" >

        <label>Type</label>
        <select id = "myList" class="list">
            <option value = "1">Cat</option>
            <option value = "2">Bird</option>
            <option value = "3">Dog</option>
            <option value = "4">Duck</option>
        </select>

        <input name="id" type="number" placeholder="id">
        <button type="submit">Search</button>

    </form>
</div>

<br/>

<article class="AnimalListing">
    <div class="image">
        <img src="images/cat.jpg" alt="cat" />
    </div>

    <div class="AnimalStats">
        <ul class="animalDisplay">
            <h3><a href="">Bob</a></h3>
            <li><strong>Type</strong>: Cat</li>
            <li><strong>Breed</strong>: Tabby</li>
            <li><strong>Description</strong>: Big fat and fuzzy</li>
            <li><strong>Notes</strong>: 5 notes</li>
        </ul>
    </div>

</article>

<br />

<article class="AnimalListing">
    <div class="image">
        <img src="images/dog.jpg" alt="dog" />
    </div>

    <div class="AnimalStats">
        <ul class="animalDisplay">
            <h3><a href="">Wanda</a></h3>
            <li><strong>Type</strong>: Dog</li>
            <li><strong>Breed</strong>: Bulldog</li>
            <li><strong>Description</strong>: A handsome beast</li>
            <li><strong>Notes</strong>: 3 notes</li>
        </ul>
    </div>

</article>

<br />

<article class="AnimalListing">
    <div>
        <img src="" alt="spider"/>
    </div>

    <div class="AnimalStats">
        <ul class="animalDisplay">
            <h3><a href="">Peter Parker</a></h3>
            <li><strong>Type</strong>: Spider</li>
            <li><strong>Breed</strong>: Trantula</li>
            <li><strong>Description</strong>: Seriously, who gets a pet spider?!</li>
            <li><strong>Notes</strong>: 0 notes</li>
        </ul>
    </div>

</article>

<br />

<article class="AnimalListing">
    <div class="">
        <img src="" alt="Fish"/>
    </div>

    <div class="AnimalStats">
        <ul class="animalDisplay">
            <h3><a href="">Roger</a></h3>
            <li><strong>Type</strong>: Fish</li>
            <li><strong>Breed</strong>: Goldfish</li>
            <li><strong>Description</strong>: It's orange.</li>
            <li><strong>Notes</strong>: 1 notes</li>
        </ul>
    </div>

</article>

</body>
</html>