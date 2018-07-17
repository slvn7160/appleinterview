package com.apple.interview;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.apple.iterview.Apple;
import com.apple.iterview.Fruit;
import com.apple.iterview.FruitContainer;
import com.apple.iterview.Orange;
import com.apple.iterview.Pear;

public class FruitContainerTest {

	@Test
	public void addFruitTest() {
		FruitContainer fruitContainer = new FruitContainer();
		int lengthBeforeAddition = fruitContainer.getFruits().size();

		Fruit apple = new Apple();
		apple.setId(1001);
		apple.setCultivar("Red Delicious");
		fruitContainer.addFruit(apple);
		int lengthAfterAddition = fruitContainer.getFruits().size();

		assertEquals(lengthBeforeAddition, lengthAfterAddition - 1);
	}

	@Test
	public void removeFruitTest() {
		FruitContainer fruitContainer = new FruitContainer();

		Fruit apple = new Apple();
		apple.setId(1001);
		apple.setCultivar("Red Delicious");

		Fruit orange = new Orange();
		orange.setId(1002);
		orange.setCultivar("Cara Cara");

		fruitContainer.addFruit(apple);
		fruitContainer.addFruit(orange);

		int lengthBeforeRemoval = fruitContainer.getFruits().size();
		fruitContainer.removeFruit(apple);
		int lengthAfterRemoval = fruitContainer.getFruits().size();

		assertEquals(lengthBeforeRemoval, lengthAfterRemoval + 1);
	}

	@Test
	public void getAllByTypeTest() {
		FruitContainer fruitContainer = new FruitContainer();

		Fruit apple = new Apple();
		apple.setId(1001);
		apple.setCultivar("Red Delicious");

		Fruit orange = new Orange();
		orange.setId(1002);
		orange.setCultivar("Cara Cara");

		Fruit apple2 = new Apple();
		apple2.setId(1003);
		apple2.setCultivar("Granny Smith");

		fruitContainer.addFruit(apple);
		fruitContainer.addFruit(orange);
		fruitContainer.addFruit(apple2);

		fruitContainer.getAll("Apple").forEach(x -> assertTrue(x instanceof Apple)); 		// all items must be instance of Apple class
	}

	@Test
	public void getAllTest() {
		FruitContainer fruitContainer = new FruitContainer();

		Fruit apple = new Apple();
		apple.setId(1001);
		apple.setCultivar("Red Delicious");

		Fruit orange = new Orange();
		orange.setId(1002);
		orange.setCultivar("Cara Cara");

		Fruit apple2 = new Apple();
		apple2.setId(1003);
		apple2.setCultivar("Granny Smith");

		fruitContainer.addFruit(apple);
		fruitContainer.addFruit(orange);
		fruitContainer.addFruit(apple2);

		List<Fruit> fruits = new ArrayList<>();
		fruits.add(apple);
		fruits.add(orange);
		fruits.add(apple2);

		assertEquals(fruitContainer.getAll(), fruits); // both list must be equal
	}

	@Test
	public void orderFruitByTypeTest() {
		FruitContainer fruitContainer = new FruitContainer();

		Fruit apple = new Apple();
		apple.setId(1001);
		apple.setCultivar("Red Delicious");

		Fruit orange = new Orange();
		orange.setId(1002);
		orange.setCultivar("Cara Cara");

		Fruit apple2 = new Apple();
		apple2.setId(1003);
		apple2.setCultivar("Granny Smith");

		Fruit pear = new Pear();
		pear.setId(1004);
		pear.setCultivar("D'Anjou");

		// adding fruits
		fruitContainer.addFruit(apple);
		fruitContainer.addFruit(orange);
		fruitContainer.addFruit(apple2);
		fruitContainer.addFruit(pear);

		fruitContainer.orderFruitByType(); // sorting fruit by type

		List<Fruit> fruits = fruitContainer.getAll();
		assertEquals(fruits.get(0).getClass(), Apple.class); // first one should be apple
		assertEquals(fruits.get(1).getClass(), Apple.class); // Second one should be apple
		assertEquals(fruits.get(2).getClass(), Orange.class); // third one should be orange
		assertEquals(fruits.get(3).getClass(), Pear.class); // fourth one should be pear
	}

}
