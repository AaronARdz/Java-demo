import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {
        Album album = new Album("Stormbringer","Deep Purple");
        Album album2 = new Album("The Wall", "Pink Floyd");


        album.addSong("Stormbringer", 4.6);
        album.addSong("Holy Man", 2.56);
        album.addSong("Nightcall", 7.24);
        album.addSong("The gipsy", 4.26);
        album.addSong("Phantom Dance", 3.05);
        album.addSong("Soldier of fortune", 3.23);
        albums.add(album);


        Album album1 = new Album("For those about to rock", "AC/DC");
        album1.addSong("Thunderstruck", 3.55);
        album1.addSong("For those about to rock", 3.55);
        album1.addSong("I put the finger on you", 3.55);
        album1.addSong("Let's go", 3.55);
        album1.addSong("Hells bells", 3.55);
        album1.addSong("Evil Walks", 3.55);
        albums.add(album1);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlaylist("Stormbringer", playList);
        albums.get(0).addToPlaylist("Holy Man", playList);
        albums.get(0).addToPlaylist("The gipsy", playList);
        albums.get(0).addToPlaylist("Bad and boujee", playList);//does not exist
        albums.get(0).addToPlaylist(3,playList);
        albums.get(1).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(2, playList);
        albums.get(1).addToPlaylist(5, playList);

        play(playList);
    }
    private static void play(LinkedList<Song> playlist){
        Scanner scanner  = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now Playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.next());
                        }
                    }
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions:\n press ");
        System.out.println("0 - to quit");
        System.out.println("1 - to forward");
        System.out.println("2 - to previous");
        System.out.println("3 - to replay");
        System.out.println("4 - to printPlaylist");
        System.out.println("5 - to printMenu");
        System.out.println("6 - to Delete Current Song");
    }
    private static void printPlaylist(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("====================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=====================================");
    }

















}






















