   public  class parkingSpot  //This class includes all information about the parking spots and also it keeps track of whether parking spot is occupied or not.
    {

// instance variables
        int spot_id;
        int cluster_number;
        int region_number;
        int group_center_number;
        int occupied; // 1 if yes and 0 if no
        int carIdOccupyThisSpot; // the car id that is parking in this spot

        // constructor
        public void parkingSpots(int spot_id, int cluster_number, int region_number, int group_center_number, int occupied)
    {
        this.spot_id = spot_id;
        this.cluster_number = cluster_number;
        this.region_number = region_number;
        this.group_center_number = group_center_number;
        this.occupied = occupied;
    }

        public String ToString()                    // tostring for spot in the parking lots information
        {
        	String result = "";
            result = "\n" +
            "************ "+"\n" +
            "		Spot Information		        "+"\n"+
           "************** "+"\n"+
            "Spot number : "+spot_id+" \n "+
            "Cluster number : "+cluster_number+" \n "+
           "Region number : "+region_number+" \n "+
            "Group Center number : "+group_center_number+" \n "+
            "Occupied : "+occupied+" \n " +"\n";
            return result;
        }


    }
