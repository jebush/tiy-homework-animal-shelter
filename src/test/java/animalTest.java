//port org.junit.Test;

//port static org.hamcrest.CoreMatchers.*;
//port static org.hamcrest.MatcherAssert.assertThat;


//blic class animalTest {
//  @Test
//  public void getNameTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      String name = animal.getName();
//      //assert
//      assertThat(name, is(equalTo("Steve")));
//  }
//  @Test
//  public void getBreedTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      String breed = animal.getBreed();
//      //assert
//      assertThat(breed, is(equalTo("s")));
//  }
//  @Test
//  public void getSpeciesTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      String species = animal.getSpecies();
//      //assert
//      assertThat(species, is(equalTo("dog")));
//  }
//  @Test
//  public void getDescriptionTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      String description = animal.getDescription();
//      //assert
//      assertThat(description, is(equalTo("fun")));
//  }

//  @Test
//  public void setNameTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      animal.setName("Bob");
//      //assert
//      assertThat(animal.getName(), is(equalTo("Bob")));
//  }

//  @Test
//  public void setSpeciesTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      animal.setSpecies("Parrot");
//      //assert
//      assertThat(animal.getSpecies(), is(equalTo("Parrot")));
//  }

//  @Test
//  public void setBreedTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      animal.setBreed("Bird");
//      //assert
//      assertThat(animal.getBreed(), is(equalTo("Bird")));
//  }

//  @Test
//  public void setDescriptionTest(){
//      //arrange
//      entities.Animal animal = new entities.Animal("Steve", "dog", "s", "fun");
//      //act
//      animal.setDescription("Will Claw eyes out");
//      //assert
//      assertThat(animal.getDescription(), is(equalTo("Will Claw eyes out")));
//  }


//
