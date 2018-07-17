package com.apple.iterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FruitContainer {
	
	private List<Fruit> fruits = new ArrayList<Fruit>();

	public List<Fruit> getFruits() {
		return fruits;
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}
	
	public void addFruit(Fruit fruit){
		this.fruits.add(fruit);
	}
	
	public void removeFruit(Fruit fruit){
		this.fruits.remove(fruit);
	}
	
	public List<? extends Fruit> getAll(String fruitType) {
		return this.fruits.stream().filter(x -> x.getClass().getSimpleName().toLowerCase().contains(fruitType.toLowerCase())).collect(Collectors.toList());
	}
	
	public List<Fruit> getAll() {
		return fruits;
	}
	
	public void orderFruitByType(){
		Collections.sort(this.fruits, (f1, f2)-> f1.getClass().getName().compareTo(f2.getClass().getName()));
	}

}
