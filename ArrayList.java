/*--------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Spring 2025

TODO : Document this file

authors: Yusra Faheem, Charles Peeke
--------------------------------------------------------------------------*/
public class ArrayList implements MusicCatalog {
    // For an array-based list, the array itself
    private CatalogItem[] data;
    // The counter to track the number of elements in the list
    private int count;

    // Parameterless Constructor
    public ArrayList() {
        count = 0;
        data = new CatalogItem[2];
    }
   
    /// TODO : Document this function
    public void add(Song song) {
        // checks whether the data array is full or not 
        if (count == data.length){
            // creates an array double the length of the original 
            CatalogItem[] newSong = new CatalogItem[data.length * 2]; 
            // copies every element in the original array 
            for (int i = 0; i< count; i++){ 
                newSong[i] = data[i]; 

            }
            // the data array now points to the new, larger array 
            data = newSong; 
        }
        // stores the new song in the new array 
        data[count] = new CatalogItem(song); 
        count++; 

        // TODO : Implement this function
    }

    /// TODO : Document this function
    public Song remove() {
        // checks if it's an empty array/ you can't remove from an empty array 
        if (count==0) return null; 
        // Brings us the song object from the first CatalogItem in the array 
        Song removedSong = data[0].getSong();  
        for (int i = 1; i < count; i++){ 
            // There is now a gap so each element in the data set is shifted to the left to account for this
            data[i - 1] = data[i]; 
        }
        // Gets rid of the last element as it now has a copy 
        data[count - 1] = null; 
        // the number of items in the list now goes down by 1 
        count--; 
    


        // returns the song we took out of the list 
        return removedSong;
    }

    /// TODO : Document this function
    public Song remove(Song song) {
        // loop for each element in the array list 
        for (int i = 0; i < count; i++) { 
            // Checks if the song stored in the CatalogItem is equal to the song to be removed 
            if (data[i].getSong().equals(song)){
                // declares a variable for the removed song 
                Song removedSong = data[i].getSong();
                // shifts all the elements to account for removing one 
                for (int j = i + 1; j < count; j++){ 
                    // shifts each item to accunt for the gap in the list 
                    data[j - 1] = data[j]; 
            

                } 
                // clears the last element in the last as we now have a copy 
                data[count - 1] = null; 
                // decreases the element count since we removed an element
                count--; 
                return removedSong; 
            }
        }
        // TODO : Implement this function
// if the song wasn't found in the list, return null
        return null;
    }
    
    /// TODO : Document this function
    public void clear() {
        // creates a new array with two empty slots 
        data = new CatalogItem[2]; 
        // resets the counter to 0 
        count = 0; 
        // TODO : Implement this function
    }
    
    /// 
    /// 
    /// Checks if the music catalog is empty 
    public boolean isEmpty() {
    
        // TODO : Implement this function
// if true, then the count is 0
        return count ==0;
    }
    
    /// returns the number of songs that are in the catalog 
    public int count() {
        // TODO : Implement this function

        return count;
    }
    
    /// TODO : Document this function
    /// i is the index of the song we want to get from the list 
    public Song get(int i) {
        // ensures the index is within the array for the duration of the function
        if (i < 0 || i >= count) return null; 

        // Retrieves the song within the catalog iten 

        return data[i].getSong();
    }

    /// TODO : Document this function
    public boolean contains(Song song) {
        //iterates through each item in the list to search each item 
        for (int i = 0; i < count; i++) { 
            // check to see if the song equals the one we are trying to find 
            if (data[i].getSong().equals(song)) return true;

        }
        // TODO : Implement this function
        // if the loop runs through and you don't have a match, return false for its presence 

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
        if(data == null) {
            return false;
        }
        if(count > data.length) {
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(data[i] == null) {
                return false;
            }
        }

        return true;
    }

    /// Returns a string that contains information about the list and the 
    /// contents of the list.  This is mostly useful for visual debugging 
    /// @return a string containing information about the contents of the 
    ///         catalog
    public String toString() {
        String s = "";
        s = "ArrayList::allocated=" + data.length;
        s += ", count=" + count(); 
        s += ", isEmpty=" + isEmpty(); 
        s += ", ["; 
        for(int i = 0; i < count; i++) {
            if(i > 0) {
                s += ", ";
            }
            s += data[i].getSong().getTitle();
            s += " | ";
            s += data[i].getSong().getYear();
        }
        s += "]";
        return s;
    }

    /// Returns the earliest and most recent years of all the songs in the
    /// catalog and then clears the catalog of all songs
    /// @return an array of the years of the earliest and most recent songs
    public int[] publish() {
        int oldYear = Integer.MAX_VALUE;
        int newYear = Integer.MIN_VALUE;

        for(int i = 0; i < count; i++) {
            int curYear = data[i].getSong().getYear();
            if (curYear < oldYear) oldYear = curYear;
            if (curYear > newYear) newYear = curYear;
        }
        clear();
        return new int[] { oldYear, newYear };
    }

}
