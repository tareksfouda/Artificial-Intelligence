import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class Simulation {
//instance variables
    int jobscompleted =0;
    int jobsmigratedsuccessfully = 0;
    int jobsfailedtomigrate = 0;
    int failedToFindParking =0;
    static int timetostopSimulation = 1440;       // the simulation will run for one day, 24 hours, 1440mins
    int spot;
    static double bandwidth = 3250;   // The disk bandwidth 54Mb/s is expressed in minutes as 3240 Mb/minute as stated in the project statement. 
    int jobfailCounter=0, jobPassCounter=0;
    int[] Array_first_spot_of_cluster = new int[65];
    // three main arrays
     parkingSpot[] parking_spot; // 2560 parking spots objects
     jobs[] jobs= new jobs[7680];  // 7680 jobs assigned to 7680 cars which are the number of employees in this company
     cars[] cars= new cars[7680]; // number of cars in this plant(company) or number of employees




 // **************************** Main method and Initializing data**********************************
    
    // regions, the four regions
    public void regioncenter1()
    {

        //For Region1

        for(int i=1;i<=640;i++)
        {
           
			if( i <= 160)
            {
                if( i <= 40 )
                {
                    parking_spot[i-1].parkingSpots(i-1,1,1,1,1);
                }

                if( i > 40  && i <= 80 )
                {
                    parking_spot[i-1].parkingSpots(i-1,2,1,1,1);
                }

                if( i > 80 && i <= 120 )
                {
                    parking_spot[i-1].parkingSpots(i-1,3,1,1,1);
                }

                if( i > 120 && i <= 160 )
                {
                    parking_spot[i-1].parkingSpots(i-1,4,1,1,1);

                }
            }

            if( i > 160 && i <= 320)
            {
                if( i > 160 && i <= 200 )
                {
                    parking_spot[i-1].parkingSpots(i-1,5,1,2,1);
                }

                if( i > 200  && i <= 240 )
                {
                    parking_spot[i-1].parkingSpots(i-1,6,1,2,1);
                }

                if( i > 240 && i <= 280 )
                {
                    parking_spot[i-1].parkingSpots(i-1,7,1,2,1);
                }

                if( i > 280 && i <= 320 )
                {
                    parking_spot[i-1].parkingSpots(i-1,8,1,2,1);

                }
            }

            if( i > 320 && i <= 480)
            {
                if( i > 320 && i <= 360 )
                {
                    parking_spot[i-1].parkingSpots(i-1,9,1,3,1);
                }

                if( i > 360  && i <= 400 )
                {
                    parking_spot[i-1].parkingSpots(i-1,10,1,3,1);
                }

                if( i > 400 && i <= 440 )
                {
                    parking_spot[i-1].parkingSpots(i-1,11,1,3,1);
                }

                if( i > 440 && i <= 480 )
                {
                    parking_spot[i-1].parkingSpots(i-1,12,1,3,1);

                }
            }

            if( i > 480 && i <= 640)
            {
                if( i > 480 && i <= 520 )
                {
                    parking_spot[i-1].parkingSpots(i-1,13,1,4,1);
                }

                if( i > 520  && i <= 560 )
                {
                    parking_spot[i-1].parkingSpots(i-1,14,1,4,1);
                }

                if( i > 560 && i <= 600 )
                {
                    parking_spot[i-1].parkingSpots(i-1,15,1,4,1);
                }

                if( i > 600 && i <= 640 )
                {
                    parking_spot[i-1].parkingSpots(i-1,16,1,4,1);

                }
            }
        }

    }
    public void regioncenter2()
    {

        //For Region2

        for(int i=641;i<=1280;i++)
        {
            if( i <= 800)
            {
                if( i <= 680 )
                {
                    parking_spot[i-1].parkingSpots(i-1,17,2,5,1);
                }

                if( i > 680  && i <= 720 )
                {
                    parking_spot[i-1].parkingSpots(i-1,18,2,5,1);
                }

                if( i > 720 && i <= 760 )
                {
                    parking_spot[i-1].parkingSpots(i-1,19,2,5,1);
                }

                if( i > 761 && i <= 800 )
                {
                    parking_spot[i-1].parkingSpots(i-1,20,2,5,1);

                }
            }

            if( i > 800 && i <= 960)
            {
                if( i > 800 && i <= 840 )
                {
                    parking_spot[i-1].parkingSpots(i-1,21,2,6,1);
                }

                if( i > 840  && i <= 880 )
                {
                    parking_spot[i-1].parkingSpots(i-1,22,2,6,1);
                }

                if( i > 880 && i <= 920 )
                {
                    parking_spot[i-1].parkingSpots(i-1,23,2,6,1);
                }

                if( i > 920 && i <= 960 )
                {
                    parking_spot[i-1].parkingSpots(i-1,24,2,6,1);

                }
            }

            if( i > 960 && i <= 1120)
            {
                if( i > 960 && i <= 1000 )
                {
                    parking_spot[i-1].parkingSpots(i-1,25,2,7,1);
                }

                if( i > 1000  && i <= 1040 )
                {
                    parking_spot[i-1].parkingSpots(i-1,26,2,7,1);
                }

                if( i > 1040 && i <= 1080 )
                {
                    parking_spot[i-1].parkingSpots(i-1,27,2,7,1);
                }

                if( i > 1080 && i <= 1120 )
                {
                    parking_spot[i-1].parkingSpots(i-1,28,2,7,1);

                }
            }

            if( i > 1120 && i <= 1280)
            {
                if( i > 1120 && i <= 1160 )
                {
                    parking_spot[i-1].parkingSpots(i-1,29,2,8,1);
                }

                if( i > 1160  && i <= 1200 )
                {
                    parking_spot[i-1].parkingSpots(i-1,30,2,8,1);
                }

                if( i > 1200 && i <= 1240 )
                {
                    parking_spot[i-1].parkingSpots(i-1,31,2,8,1);
                }

                if( i > 1240 && i <= 1280 )
                {
                    parking_spot[i-1].parkingSpots(i-1,32,2,8,1);

                }
            }
        }

    }
   public  void regioncenter3()
    {

        //For Region3

        for(int i=1281;i<=1920;i++)
        {
            if( i <= 1440)
            {
                if( i <= 1320 )
                {
                    parking_spot[i-1].parkingSpots(i-1,33,3,9,1);
                }

                if( i > 1320  && i <= 1360 )
                {
                    parking_spot[i-1].parkingSpots(i-1,34,3,9,1);
                }

                if( i > 1360 && i <= 1400 )
                {
                    parking_spot[i-1].parkingSpots(i-1,35,3,9,1);
                }

                if( i > 1400 && i <= 1440 )
                {
                    parking_spot[i-1].parkingSpots(i-1,36,3,9,1);

                }
            }

            if( i > 1440 && i <= 1600)
            {
                if( i > 1440 && i <= 1480 )
                {
                    parking_spot[i-1].parkingSpots(i-1,37,3,10,1);
                }

                if( i > 1480  && i <= 1520 )
                {
                    parking_spot[i-1].parkingSpots(i-1,38,3,10,1);
                }

                if( i > 1520 && i <= 1560 )
                {
                    parking_spot[i-1].parkingSpots(i-1,39,3,10,1);
                }

                if( i > 1560 && i <= 1600 )
                {
                    parking_spot[i-1].parkingSpots(i-1,40,3,10,1);

                }
            }

            if( i > 1600 && i <= 1760)
            {
                if( i > 1600 && i <= 1640 )
                {
                    parking_spot[i-1].parkingSpots(i-1,41,3,11,1);
                }

                if( i > 1640  && i <= 1680 )
                {
                    parking_spot[i-1].parkingSpots(i-1,42,3,11,1);
                }

                if( i > 1680 && i <= 1720 )
                {
                    parking_spot[i-1].parkingSpots(i-1,43,3,11,1);
                }

                if( i > 1720 && i <= 1760 )
                {
                    parking_spot[i-1].parkingSpots(i-1,44,3,11,1);

                }
            }

            if( i > 1760 && i <= 1920)
            {
                if( i > 1760 && i <= 1800 )
                {
                    parking_spot[i-1].parkingSpots(i-1,45,3,12,1);
                }

                if( i > 1800  && i <= 1840 )
                {
                    parking_spot[i-1].parkingSpots(i-1,46,3,12,1);
                }

                if( i > 1840 && i <= 1880 )
                {
                    parking_spot[i-1].parkingSpots(i-1,47,3,12,1);
                }

                if( i > 1880 && i <= 1920 )
                {
                    parking_spot[i-1].parkingSpots(i-1,48,3,12,1);

                }
            }
        }

    }
    public void regioncenter4()
    {

        //For Region4

        for(int i=1921;i<=2560;i++)
        {
            if( i <= 2080)
            {
                if( i <= 1960 )
                {
                    parking_spot[i-1].parkingSpots(i-1,49,4,13,1);
                }

                if( i > 1960  && i <= 2000 )
                {
                    parking_spot[i-1].parkingSpots(i,50,4,13,1);
                }

                if( i > 2000 && i <= 2040 )
                {
                    parking_spot[i-1].parkingSpots(i,51,4,13,1);
                }

                if( i > 2040 && i <= 2080 )
                {
                    parking_spot[i-1].parkingSpots(i-1,52,4,13,1);

                }
            }

            if( i > 2080 && i <= 2240)
            {
                if( i > 2080 && i <= 2120 )
                {
                    parking_spot[i-1].parkingSpots(i-1,53,4,14,1);
                }

                if( i > 2120  && i <= 2160 )
                {
                    parking_spot[i-1].parkingSpots(i-1,54,4,14,1);
                }

                if( i > 2160 && i <= 2200 )
                {
                    parking_spot[i-1].parkingSpots(i-1,55,4,14,1);
                }

                if( i > 2200 && i <= 2240 )
                {
                    parking_spot[i-1].parkingSpots(i-1,56,4,14,1);

                }
            }

            if( i > 2240 && i <= 2400)
            {
                if( i > 2240 && i <= 2280 )
                {
                    parking_spot[i-1].parkingSpots(i-1,57,4,15,1);
                }

                if( i > 2280  && i <= 2320 )
                {
                    parking_spot[i-1].parkingSpots(i-1,58,4,15,1);
                }

                if( i > 2320 && i <= 2360 )
                {
                    parking_spot[i-1].parkingSpots(i-1,59,4,15,1);
                }

                if( i > 2360 && i <= 2400 )
                {
                    parking_spot[i-1].parkingSpots(i-1,60,4,15,1);

                }
            }

            if( i > 2400 && i <= 2560)
            {
                if( i > 2400 && i <= 2440 )
                {
                    parking_spot[i-1].parkingSpots(i-1,61,4,16,1);
                }

                if( i > 2440  && i <= 2480 )
                {
                    parking_spot[i-1].parkingSpots(i-1,62,4,16,1);
                }

                if( i > 2480 && i <= 2520 )
                {
                    parking_spot[i-1].parkingSpots(i-1,63,4,16,1);
                }

                if( i > 2520 && i <= 2560 )
                {
                    parking_spot[i-1].parkingSpots(i-1,64,4,16,1);

                }
            }
        }

    }


    public int randomclusterinSameRegion(int GC_number_of_this_car, int spot_number_of_this_job, int cluster_number_of_this_car){

        int car_number = 0;
        int spot_number;
        int random_number;
        int random_cluster_number=0;
        int GC_num;

        //initializing the array
        
        for(int i=0; i <=64; i++){

            Array_first_spot_of_cluster[i]=0;
        }

        Array_first_spot_of_cluster[1]=1;

        for(int i=2; i <=64; i++){

            Array_first_spot_of_cluster[i]=Array_first_spot_of_cluster[i-1] + 40;
        }
// done with initializing the array

        random_number=1;
        for(GC_num=1;GC_num<=16;GC_num++)
        {
            if (GC_number_of_this_car==GC_num){

             
                random_cluster_number=0;

                do
                {
                    random_cluster_number= (int) (Math.random()%4 + random_number) ; //generate 1 to 4
                }while(random_cluster_number==cluster_number_of_this_car);

                
                
                int spot_num=Array_first_spot_of_cluster[random_cluster_number];
                for(int i=Array_first_spot_of_cluster[random_cluster_number]+1;i<=Array_first_spot_of_cluster[random_cluster_number]+39;i++)
                {
                    if(i == spot_number_of_this_job)    //This will skip the assigning the job to same car in the cluster.
                    {

                        continue;
                    }

                    if(cars[spot_num].departure_time <cars[i].departure_time)
                        spot_num = i;

                }
                car_number =  cars[spot_num].car_id;
                
                
                
                
                
                

            }
            random_number=random_number + 4;

        }


        return car_number;
    }


    public void run() throws NumberFormatException, IOException

    {
        this.parking_spot =  new parkingSpot[2560]; // 2560 parking spots objects
        this.jobs= new jobs[7680];  // 7680 jobs assigned to 7680 cars which are the number of employees in this company
        this.cars= new cars[7680]; // number of cars in this plant(company) or number of employees
        int carsToKeepTrackOf=0, totalOfcars=0;
        //File file = new File("Z:\\artificial_intelligence\\Cloud_Computing\\input.txt");
    //    System.out.println(file.getAbsolutePath());
       // FileInputStream fstream = new FileInputStream("input.txt");
    	FileReader file = new FileReader("C:/Users/tfouda.CS.001/Desktop/test.txt");
    	BufferedReader reader = new BufferedReader(file);
       // FileInputStream fstream = new FileInputStream("Z:\\artificial_intelligence\\Cloud_Computing\\input.txt");
      //  BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        // Assigning the carnumbers for all available 7680 cars
       // System.out.println(cars[1].carArrivalTime);
        for(int i=1; i<=7680; i++)
        {
	        	cars[i-1] = new cars();
            this.cars[i-1].car_id = i-1;
           this.cars[i-1].busy = false;



        }

        String inputline;
        int idOfCars = 0;
        // assigning the arrival time for all of the cars
        
        
        while ((inputline = reader.readLine()) != null)   {
        	//System.out.println(strLine + "sksksk");

            cars[idOfCars].carArrivalTime = Integer.parseInt(inputline);
            idOfCars++;
        
        }
        //close the input stream
        reader.close();
        
        //initiaalize spot numbers
        for(int i=1; i<=2560; i++)
        {
        	this.parking_spot[i-1] = new parkingSpot();

        }
        //Initialize all spot numbers, job numbers, departure time to all the cars
        for(int i=1; i<=2560; i++)
        {
            cars[i-1].car_assignedSpotNumber = parking_spot[i-1].spot_id;
            parking_spot[i-1].carIdOccupyThisSpot = i-1 ;
            cars[i-1].job_number=i-1;
            cars[i-1].calculate_departure_time();
            cars[i-1].calculate_timeSpenInThePlant_of_car();
            cars[i-1].turned_away=0;
            cars[i-1].busy = true;

        }
        // calculate departure time for the rest of the cars and no assigned spot
        for(int j = 2561;j<=7680;j++){
            cars[j-1].calculate_departure_time();
            cars[j-1].calculate_timeSpenInThePlant_of_car();
            cars[j-1].car_assignedSpotNumber = -1;
        	
        }




        regioncenter1(); //This will initialize the spot locations of all clusters belonging to region center1.
        regioncenter2();  //This will initialize the spot locations of all clusters belonging to region center2.
        regioncenter3();  //This will initialize the spot locations of all clusters belonging to region center3.
        regioncenter4(); //This will initialize the spot locations of all clusters belonging to region center4.
        
        // Initialize all 7680 jobs for job class
        for(int i=1; i<=7680; i++)
        {
        	jobs[i-1] = new jobs();
            jobs[i-1].job_id = i-1;
            jobs[i-1].calculate_job_duration();
            jobs[i-1].completed=false;
            jobs[i-1].assigned=false;

        }

      
        
        // Assigning jobs to cars and setting the assigned flag for job class.
        for(int i=1; i<=2560; i++)
        {

            if(cars[i].job_number==jobs[i].job_id){
                jobs[i].car_id=cars[i].car_id;
                jobs[i].assigned=true;
            }
            else
            {
                jobs[i].car_id=-1;
                jobs[i].assigned=false;
            }
        }

        
        
        


        PrintWriter writer = new PrintWriter("C:/Users/tfouda.CS.001/Desktop/words.txt", "UTF-8");
        //Displays all spot information.
        writer.println(" ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
    	writer.println(" Displaying all the parking spot information after initialization and before simulation starts");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
    	  writer.println(" ");
        for(int i=1;i<=2560;i++)
        {
        	writer.println(" ");
            writer.println(parking_spot[i-1].ToString());
            
        }
        writer.println(" ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" End of Displaying all the parking spot information after initialization and before simulation starts ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" Displaying all the cars and jobs information after initialization and before simulation starts ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" ");
        // Displaying all car and job information
        for(int i=1; i<=7680; i++)
        {
        	writer.println(" ");
        	writer.println("**********");
            writer.println(cars[i-1].ToString()); //tostring of every car
            int job_number = jobs[i-1].job_id;
            writer.println(jobs[job_number].ToString()); // job id that corresponds to this car
            writer.println("**********");
            writer.println(" ");
            
            if(cars[i-1].departure_time <= timetostopSimulation) // these are the cars that we can keep track of completely
            {
                carsToKeepTrackOf++;
                writer.println(" ");
                writer.println("**********");
                writer.println(cars[i-1].ToString());
                writer.println("Count of Cars that we can completely keep track of : "+carsToKeepTrackOf);
                writer.println("**********");
                writer.println(" ");
            }

            if(cars[i-1].carArrivalTime <= timetostopSimulation)
            {
                totalOfcars++;
                writer.println(" ");
                writer.println("**********");
                writer.println("Cars that might leave after the simulation time ends : ");
                writer.println(cars[i-1].ToString());
                writer.println("**********");
                writer.println(" ");
            }


        }
        writer.println(" ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" End of Displaying all the cars and jobs information after initialization and before simulation starts ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" ");


        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" The simulation starts now at minute 1 and till 1440 ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        // Simulation time in minutes that is run for 24 hours which is equal to 1440 minutes.
        int time = 0;
        writer.println(" ");
        writer.println( "\nTime is: " + time);
        writer.println(" ");
        // start of simulation loop
        // i is the minute and c is the car
        for (int i=1; i<=1440; i++){  //1440 or 24 hours
            time++;
            writer.println(" ");
            writer.println( "\nTime is: " + time);
            writer.println(" ");

            
           
            for(int c=1; c<=7680; c++)
            {
            	
                // assigning new cars to the parking lot if their arrival time equals the minute value and they have no
                //spot number assigned
                
                if( c>=2561 && cars[c-1].carArrivalTime == i && cars[c-1].car_assignedSpotNumber == -1 && cars[c-1].turned_away != 1){
                    for (int s=1; s<=2560; s++){
                        if (parking_spot[s-1].occupied == -1 ){
                            cars[c-1].car_assignedSpotNumber = parking_spot[s-1].spot_id;
                            parking_spot[s-1].carIdOccupyThisSpot=cars[c-1].car_id;
                            parking_spot[s-1].occupied = 1;
                            cars[c-1].turned_away = 0;
                            cars[c-1].busy=false;
                            break;
                        }
                        else{
                            cars[c-1].turned_away = 1;

                        }

                    }
                }
                if(i>=cars[c-1].departure_time) // if simulation is larger than departure time of any car, this car leaves and its spot location 
                	// and job should be set to false
                {
                    spot = cars[c-1].car_assignedSpotNumber;

                    parking_spot[spot].carIdOccupyThisSpot = cars[c-1].car_id;

                    parking_spot[spot].occupied= -1; // not occupied anymore

                    int job_var = cars[c-1].job_number;

                    jobs[job_var].assigned = false; //if the car leaves we will un assign the job

                    cars[c-1].car_assignedSpotNumber = -1;

                    cars[c-1].busy=false;


                }



                // if the job duration of a specific car is greater than the time the car will spend
                //so we will migrate the job within 1 mins before the car leaves
                int job_num_var = cars[c-1].job_number;

                if ( cars[c-1].nojobsmigrated==false && cars[c-1].timeSpenInThePlant < jobs[job_num_var].job_duration && 
                		i >= cars[c-1].departure_time - 1 && cars[c-1].car_assignedSpotNumber != -1 ){

                    //find the car with later departure time than the car that isabout toleave now
                	
                    int car_num = -1;
                    int timeSpenInThePlant_temp= -1;
                    
                    // loop to choose a good car for the job
                    for ( int j=1; j<=7680; j++){

                        if(cars[j-1].busy == false && cars[j-1].departure_time > i && cars[j-1].car_assignedSpotNumber != -1 &&
                        		(cars[j-1].departure_time > cars[c-1].departure_time + (jobs[job_num_var].job_duration_remained)) && (jobs[job_num_var].job_duration_remained) < cars[c-1].timeSpenInThePlant ){

                            timeSpenInThePlant_temp= cars[i-1].timeSpenInThePlant;
                            car_num = cars[i-1].car_id;
                        }

                    }
                    
                    int temp_car_num_for_migration= car_num;

                    if (temp_car_num_for_migration != -1){ // we found a suitable car to migrate to
                    	writer.println(" ");
                    	writer.println("**************************************************** ");
                    	writer.println( "we migrated this job number " + job_num_var +" to car number " + temp_car_num_for_migration + " at time " +i );
                    	writer.println("**************************************************** ");
                    	writer.println(" ");
                        //migrate the job process
                        cars[temp_car_num_for_migration].job_number= job_num_var;
                        cars[temp_car_num_for_migration].busy=true;
                        jobs[job_num_var].assigned=true;
                        cars[c].nojobsmigrated=true;
                        jobs[job_num_var].car_id=temp_car_num_for_migration;
                        jobs[job_num_var].migrated_successfully = true;

                    }
                    else if (temp_car_num_for_migration == -1){  // we copuldnt find a suitable car to migrate to
                    	writer.println(" ");
                    	writer.println("**************************************************** ");
                    	writer.println( "we failed to migrate this job number " + job_num_var + " at time" + i );
                    	writer.println("**************************************************** ");
                    	writer.println(" ");
                        jobs[job_num_var].migrated_successfully = false;
                    }

                }



            }
            
   


            // Set the status of the jobs if it is finished successully.
            for(int j=1; j<=2560; j++)
            {


                if (jobs[j-1].job_duration_remained <= 0){
                    jobs[j-1].completed=true;
                    int temp_car_number = jobs[j-1].car_id;
                    cars[temp_car_number].busy=false;
                }

                if (jobs[j-1].assigned==true && jobs[j-1].completed==false)
                    jobs[j-1].job_duration_remained--;


                int jobremained = (int)(jobs[j-1].job_duration_remained);
                int jobdur = (int)((jobs[j-1].job_duration)/2);
                if ( jobremained == jobdur  ){
                    int car_number_of_this_job =  jobs[j-1].car_id;
                    int spot_number_of_this_job = cars[car_number_of_this_job].car_assignedSpotNumber;
                    int cluster_number_of_this_job = parking_spot[spot_number_of_this_job].cluster_number;
                    writer.println(" ");
                    writer.println( "************************************cluster_number_of_this_job******************" + cluster_number_of_this_job);
                    


                    for (int cc=1 ; cc <= 7680 ; cc++){

                        int spot_number_of_this_car = cars[cc-1].car_assignedSpotNumber;
                        int GC_number_of_this_car = parking_spot[spot_number_of_this_car].group_center_number;
                        int cluster_number_of_this_car = parking_spot[spot_number_of_this_car].cluster_number;
                        if((cluster_number_of_this_car == cluster_number_of_this_job) && parking_spot[spot_number_of_this_car].occupied!=-1){   /// change this if statement to find a car that is has the biggest residency time

                        	
                        	
                        	 int spot_num=spot_number_of_this_car;
                             for(int z=spot_number_of_this_car+1;z<=spot_number_of_this_car+39;z++)
                             {
                                 if(z == spot_number_of_this_job)    //This will skip the assigning the job to same car in the cluster.
                                 {

                                     continue;
                                 }

                                 if(cars[spot_num].departure_time <cars[z].departure_time)
                                     spot_num = z;

                             }
                             jobs[j].data1_car_number =  cars[spot_num].car_id;
                         
                             
                             
                             
                         
                             writer.println("Car number: "+car_number_of_this_job+" belonging to spot number: "+spot_number_of_this_job+" and cluster number: "+cluster_number_of_this_job+" is replicated to car "+jobs[j].data1_car_number+" belonging to same cluster"+" at job duration "+jobs[j].job_duration_remained); // replicate it to any car in the same region

                            int carnumber_another_cluster=randomclusterinSameRegion(GC_number_of_this_car, spot_number_of_this_job, cluster_number_of_this_car);


                            writer.println("Car number: "+car_number_of_this_job+" belonging to spot number: "+spot_number_of_this_job+" and cluster number: "+cluster_number_of_this_job+" is replicated to car "+carnumber_another_cluster+ " at job duration "+jobs[j].job_duration_remained); // replicate it to any car in the same cluster
                           jobs[j].data2_car_number = carnumber_another_cluster; 
                            writer.println(" ");
                            
                            for(int pl = 1;pl<2560;pl++){
                            	if(parking_spot[pl].carIdOccupyThisSpot != carnumber_another_cluster && 
                            			parking_spot[pl].carIdOccupyThisSpot != jobs[j].data1_car_number &&
                            			parking_spot[pl].occupied ==1){ // replicated to any car in the parking spot
                                    writer.println("Car number: "+car_number_of_this_job+" belonging to spot number: "+spot_number_of_this_job+" and cluster number: "+cluster_number_of_this_job+" is replicated to car "+parking_spot[pl].carIdOccupyThisSpot+ " at job duration "+jobs[j].job_duration_remained);
                                    jobs[j].data3_car_number = parking_spot[pl].carIdOccupyThisSpot; 
                                    writer.println(" ");

                            	}
                            }
                            break;


                        }

                    }

                }

            }

            for(int jk=1 ; jk<=2560; jk++){//printing spot information
                int temp_carIdOccupyThisSpot = parking_spot[jk-1].carIdOccupyThisSpot;
                writer.println(" ");
                writer.println("**************************************************** ");
                writer.println("At time: " + i + " Spot " + (jk-1) + " is occupied by Car number " + parking_spot[jk-1].carIdOccupyThisSpot );
                writer.println("**************************************************** ");
                writer.println(" ");
            }

        }
        // end of simulation loop
        
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" The simulation ends now at minute 1440 ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        // This is to check the jobs passed and failed for car and its respective output is generated.

        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" Displaying the jobs that might fail and might not fail ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");       
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        writer.println(" -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- -+-+- ");
        for(int index=1; index<=2560;index++)
        {
            if(jobs[index-1].job_duration > cars[index-1].timeSpenInThePlant)
            {writer.println(" ");
            	writer.println("These are the jobs that are possibly going to fail if we don't do the migration" );
                jobfailCounter++;
                writer.println(cars[index-1].failedJobCarToString());
                writer.println(" ");

            }
            else
            {
            	writer.println(" ");
            	writer.println( "These are the jobs that will be done without migrations" );
                jobPassCounter++;
                writer.println(cars[index-1].SuccessJobCarToString());
                writer.println(" ");

            }

        }


        for (int i=1 ; i <= 7680; i++){

            if (jobs[i-1].migrated_successfully == true){
                jobsmigratedsuccessfully++;
            }

            if (jobs[i-1].migrated_successfully == false){
                jobsfailedtomigrate++;
            }

            if (cars[i-1].turned_away == 1) { // cars who turned away
                failedToFindParking++;
                writer.println("car id" + cars[i-1].car_id + " turned away" );

            }

            if ( jobs[i-1].completed == true){
                jobscompleted++;
            }
        }
        writer.println(" ");
        writer.println( "Total Cars turned away : "+failedToFindParking);
        writer.println( "Count of jobs migrated successfully " + jobsmigratedsuccessfully );
        writer.println( "Count of jobs failed to be migrated " + jobsfailedtomigrate );
        writer.println("Job failed count: "+jobfailCounter);
        writer.println( "Job Pass Count: "+jobPassCounter);
        writer.println("Total of jobs completed: " + jobscompleted );
        writer.println(" ");


    }

public static void main(String[] args) throws NumberFormatException, IOException{
	

  //  writer.println("The first line");
    //writer.println("The second line");
    
   

   // writer.close();
	Simulation s = new Simulation();
	s.run();
//	writer.close();
}

}
