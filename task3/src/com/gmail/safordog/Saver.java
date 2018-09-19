package com.gmail.safordog;

import java.io.*;
import java.lang.reflect.Field;

public class Saver {

    public Saver() {
    }

    public void toSerialize(File file) throws IOException, IllegalAccessException, NoSuchFieldException {
        if (!file.exists()) {
            file.createNewFile();
        }
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(file))) {
            OOS.writeObject(savetoString());
        } catch (IOException e) {
            System.out.println("Error save!");
        }
    }

    public String savetoString() throws IllegalAccessException {
        Car car = new Car();
        Engine engine = new Engine();
        Class<?> carClass = car.getClass();
        Class<?> engineClass = engine.getClass();
        Field[] fieldsA = carClass.getDeclaredFields();
        Field[] fieldsB = engineClass.getDeclaredFields();
        String text = "";
        for (Field field : fieldsA) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Save.class)) {
                if (field.get(car) == null) {
                    for (Field temp : fieldsB) {
                        temp.setAccessible(true);
                        if (temp.isAnnotationPresent(Save.class)) {
                            text += temp.get(engine).toString() + ";";
                        }
                    }
                } else {
                    text += (field.get(car).toString()) + ";";
                }
            }
        }
        return text;
    }

    public String[] toDeserialize(File file) throws ClassNotFoundException {
        String text = "";
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(file))) {
            text = (String) OIS.readObject();
        } catch (IOException e) {
            System.out.println("Error load!");
        }
        String[] arr = text.split(";");
        return arr;
    }

    public void toSetFields(String[] arr) throws NoSuchFieldException, IllegalAccessException {
        String carBrand = arr[0];
        String engineType = arr[1];
        double engineCapacity = Double.parseDouble(arr[2]);
        int carYear = Integer.parseInt(arr[3]);
        Car car = new Car();
        Engine engine = new Engine();
        Class<?> carClass = car.getClass();
        Class<?> engineClass = engine.getClass();
        Field brand = carClass.getDeclaredField("brand");
        Field type = engineClass.getDeclaredField("type");
        Field capacity = engineClass.getDeclaredField("capacity");
        Field year = carClass.getDeclaredField("year");
        brand.setAccessible(true);
        type.setAccessible(true);
        capacity.setAccessible(true);
        year.setAccessible(true);
        brand.set(car, carBrand);
        type.set(engine, engineType);
        capacity.set(engine, engineCapacity);
        year.set(car, carYear);
    }
}
