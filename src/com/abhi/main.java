package com.abhi;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class main{

    private static ArrayList<com.abhi.Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        com.abhi.Album album = new com.abhi.Album("Album1","Arjit Singh");

        album.addSong("THODI JAGAH",4.5);
        album.addSong("TUM HI HO",3.5);
        album.addSong("PHIR KABHI",5.0);
        albums.add(album);

        album = new com.abhi.Album("Album2","Sid SriRam");

        album.addSong("PO URAVE",4.5);
        album.addSong("PO PO YEN",3.5);
        album.addSong("HIGH ON LOVE",4.5);

        albums.add(album);

        LinkedList<com.abhi.Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("THODI JAGAH",playList_1);
        albums.get(0).addToPlayList("TUM HI HO",playList_1);
        albums.get(1).addToPlayList("PO URAVE",playList_1);
        albums.get(1).addToPlayList("PO PO YEN",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<com.abhi.Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<com.abhi.Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){

                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }

            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<com.abhi.Song> playList){
        Iterator<com.abhi.Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------");
    }

}
