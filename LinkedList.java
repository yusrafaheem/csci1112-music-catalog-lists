/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2025

TODO : Document this file

authors: Yusra Faheem, Charles Peeke
--------------------------------------------------------------------------*/
public class LinkedList implements MusicCatalog {

    // For a linked-list based list, the head pointer
    private CatalogItem head;
    // The counter to track the number of elements in the list 
    private int count;

    // Parameterless Constructor
    public LinkedList() {
        count = 0;
        head = null;
    }

    /// TODO : Document this function
    public void add(Song song) {
        // creates a new node where we will store the new song 
        CatalogItem newSongsong = new CatalogItem(song); 
        // ensures the list is not empty, if it is, then the new song is the head 
        if (head == null){ 
            // set the head to be the new song 
            head = newSongsong; 
        } else { 
            // creates a pointer to traverse the list 
            CatalogItem currentSong = head; 
            // allows the currentSong pointer to traverse the list until the end, the node where the next was null 
            while (currentSong.next != null){ 
                // moves the pointer each step forward 
                currentSong = currentSong.next; 
            }
            // adds the new song to the end of the list 
            currentSong.next = newSongsong; 
        }
    // increases the count for the number of songs by 1 
        count++; 
        }

        // 


    /// TODO : 
    public Song remove() {
        // checks if the list is empty as for an empty list we cannot remove anything 
        if (head ==null) return null; 
        // Puts the removed song at the head of the list 
        Song removed = head.getSong();
        // Makes the second node the first by removing the first node  
        head = head.next; 
        // reduces the number of songs because we have removed one item from the list 
        count--; 


        // TODO : Implement this function
// returns the removed song 
        return removed;
    }

    /// TODO : Document this function
    /// 
    public Song remove(Song song) {
        // checks if the list is empty, if it is, we cannot remove anything so we return null 
        if (head == null) return null; 
        // checks if the song that we intend to remove is currently at the head of the list 
        if (head.getSong().equals(song)){ 
            // stores the desired song to be removed inside a removed variable 
            Song removed = head.getSong(); 
            // Ensures the head pointer points to the second node in the list and makes it the new head 
            head = head.next; 
            // decreases the count or number of songs in the list by 1 
            count--; 
            // returns the removed song 
            return removed; 
        }
        // a pointer to track the previous node in the list 
        CatalogItem prevSong = head; 
        // Creates a counter from the second element in the list 
        CatalogItem currentSong = head.next; 
        //Loops through the list to see whether or not we can find the matching song 
        while (currentSong != null){ 
            // Checks to see if the current node is equal to the song we intend to remove 
            if (currentSong.getSong().equals(song)){ 
                // Stores the song we intend to remove inside a removed variable 
                Song removed = currentSong.getSong(); 
                // Skips over the node for the song once we find the removed element 
                prevSong.next = currentSong.next; 
                // decreases the count of the number of songs by 1 
                count --; 
                // returns the removed song 
                return removed; 

            }
            // Moves both the pointers forward 
            prevSong = currentSong; 
            currentSong = currentSong.next; 
        }

        // TODO : Implement this function

        // If no match for the song is found, return null because no song is removed 
        return null;
    }
    
    /// TODO : Document this function
    public void clear() {
        // renders the list useless by getting rid of the head pointer 
        head = null; 
        // sets the count pointer to 0, to show that there are no songs in the list 
        count = 0; 
        // TODO : Implement this function
    }
    
    /// TODO : Document this function
    public boolean isEmpty() {

        // Checks to see if the list is empty or not 
        // returns true if the list indeed has no items or not 
// return that the count of elements (songs) in the list is now 0 
        return count==0;
    }
    
    /// TODO : Document this function
    public int count() {
        // Counts the number of items in the list
        // Returns the number of songs in the list 

        return count;
    }
    
    /// TODO : Document this function
    /// 

    public Song get(int i) {
        // Checks to see whether or not the index is within the bounds of the array and returns null if the index is invalid 
        if (i < 0 || i >= count ) return null;
        // creates a counter variable to track the current position you're at in the list 
        int posit = 0; 
        // This variable is used for the point of traversing through the list. It starts from the first node in the list or the head
        CatalogItem currentSong = head; 
        // Goes through the loop until we get to the ith point in the list 
        while (posit< i){ 
            // Moves the iterator forward through the list 
            currentSong = currentSong.next; 
            // Increases the counter pointer for each traversion through the list 
            posit++; 
        }

        // Returns the song that is stored 

        return currentSong.getSong();
    }

    /// TODO : Document this function
    public boolean contains(Song song) {
        // Creates a pointer to traverse through the length of the linked list 
        CatalogItem currentSong = head; 
        // ensures the loop continues as long as there are more nodes to traverse 
        while (currentSong != null){ 
            // Checks to see if our song is the same as the song we are looking for to check for 
            if (currentSong.getSong().equals(song)) return true; 
            // Moves the pointer for the song to the next one in the list to continue the search algorithm 
            currentSong=currentSong.next; 


        }
        // TODO : Implement this function
        // If the song is not found for the duration of the loop, return false 

        return false;
    }

    //-----------------------------------------------------------------
    // Utilities
    //-----------------------------------------------------------------

    /// TODO Any private helper functions go here.  They must be documented


    /// Returns a truth value indicating whether the catalog's structural
    /// integrity remains valid.  If the integrity is no longer valid,
    /// then the catalog should be invalidated and usage should not be 
    /// trusted
    /// @return true if the catalog integrity is valid; otherwise, false
    public boolean isIntegrityValid() {
        if(count < 0) {
            return false;
        }
        if(count == 0 && head == null) {
            return true;
        }
        if(count == 1 && head != null && head.next == null) {
            return true;
        }

        int n = 1;
        CatalogItem it = head;
        while(it.next != null) {
            it = it.next;
            n++;
        }

        if(n != count) {
            return false;
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         catalog
    public String toString() {
        String s = "";
        s = "LinkedList::count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        CatalogItem it = head;
        while(it != null) {
            if(it != head) {
                s += ", ";
            }
            s += it.getSong().getTitle();
            s += " | ";
            s += it.getSong().getYear();
            it = it.next;
        }
        s += "]";

        return s; 
    }

    /// Returns the earliest and most recent years of all the songs in the
    /// catalog and then clears the catalog of all songs
    /// @return an array of the years of the earliest and most recent songs
    public int[] publish() {
        int[] years = new int[2];
        int oldYear = Integer.MAX_VALUE;
        int newYear = Integer.MIN_VALUE;
        years[0] = oldYear;
        years[1] = newYear;

        CatalogItem it = head;
        while(it != null) {
            int curYear = it.getSong().getYear();
            if (curYear < oldYear) {
                oldYear = curYear;
                years[0] = oldYear;
            }
            if (curYear > newYear) {
                newYear = curYear;
                years[1] = newYear;
            }
            it = it.next;
        }
        clear();
        return years;
    }

}
