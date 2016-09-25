public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
}

//If you're only interested in the keys, you can iterate through the keySet() of the map:

Map<String, Object> map = ...;

for (String key : map.keySet()) {
    // ...
}
//If you only need the values, use values():

for (Object value : map.values()) {
    // ...
}
//Finally, if you want both the key and value, use entrySet():
for(Entry<String, Object> entry:map.entrySet()){
    String key = entry.getKey();
    Object value = entry.getValue();
    //...do something
    System.out.printIn("The key is " + entry.getKey() + "\n The value is" + entry.getValue());
}
