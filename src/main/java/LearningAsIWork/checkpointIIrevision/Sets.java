package LearningAsIWork.checkpointIIrevision;

import java.util.*;


public  class Sets{

    public static void main(String[] args){

        Set<Integer> test1 = new HashSet<Integer>();

        test1.addAll(Arrays.asList(new Integer[]{1,0,2,3,4,5,6,4,7}));

        Set<Integer> test2 = new HashSet<>();
        test2.addAll(Arrays.asList(new Integer[]{0,8,6,9,3,5,2}));

        //union
        Set<Integer> union = new HashSet<>(test1);
            union.addAll(test2);

            //intersection
        Set<Integer> intersection = new HashSet<>(test1);
        intersection.retainAll(test2);

        //difference
        Set<Integer> difference = new HashSet<>(test1);
        difference.removeAll(test2);

        System.out.println("Union "+union);

        System.out.println("Intersection "+intersection);

        System.out.println("Difference "+difference);

        ///inserting into set
        Set<Integer> insert = new HashSet<>();
        insert.add(1);
        insert.add(9);
        insert.add(0);
        insert.add(3);
        insert.add(100);
        insert.add(5);
        insert.add(29);
        System.out.println(insert);

        //contains-check
        System.out.println("Contains 20 "+insert.contains(20));
        System.out.println("Contains 29 "+insert.contains(29));
        insert.remove(9);
        System.out.println(insert);

        //Iterating
        for (int values : insert){
            System.out.print(values+", ");
        }
        System.out.println();

        //iterating with iterator
        Iterator<Integer> iterator = insert.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next()+", ");
        }
        System.out.println();
        //enum set
        enum Names  {MARON, ANGELA, DENNIS, NEWTON, CARSON};
        Set<Names> enumName=  EnumSet.of(Names.MARON,Names.NEWTON,Names.CARSON,Names.ANGELA,Names.DENNIS);

        Iterator<Names> iterator1= enumName.iterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next()+", ");
        }

    //LinkedHashset - maintains insertion order
        System.out.println();
     Set<Integer> linked = new LinkedHashSet<>();
        linked.add(20);
        linked.add(1);
        linked.add(4);
        linked.add(8);
        linked.add(19);

        System.out.println(linked);

        //treeSet - stores object in sorted ascending order.
        TreeSet<Integer> tree = new TreeSet<>();
            tree.add(239);
            tree.add(156);
            tree.add(102);
            tree.add(9);
            tree.add(23);
            tree.add(1);
            tree.add(12);
        System.out.println(tree);

        //Treeset in descending order using Treeset Method descendingIterator()
      Iterator<Integer> descendingIterator = tree.descendingIterator();

        while (descendingIterator.hasNext()){
            System.out.print(descendingIterator.next());
            System.out.println();
        }


        Iterator<Integer> treeIterate = tree.iterator();
            while (treeIterate.hasNext()) {
            System.out.println(treeIterate.next());
          }

        }




}