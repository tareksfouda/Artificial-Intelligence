   public class jobs   // This class stores information about the jobs.
    {
        int car_id;  //car number that the job belongs to
        int job_id;
        double VM_size = 1000;   // VM size is 1 GB
        boolean completed;
        boolean assigned;
        double job_duration;   // in minute
        double data_this_job_will_produce = 1000 * 2; // assumption that the data is vm size * 2
        double data_storage_time = data_this_job_will_produce/3250;   // The disk bandwidth 54Mb/s is expressed in minutes as 3240 Mb/minute as stated in the project statement.  ;
        double job_duration_remained;
        int data1_car_number;
        int data2_car_number;
        int data3_car_number;
        String replicated_data;
        boolean migrated_successfully; // true if migrated successfully and false if not



      public String ToString()                 //This displays the job information which is assigned to all the cars in the parking lot as soon as simulation starts.
        {
    	  String result="";
            result = "\n" + "******************** "+" \n " 
    	  + "		Job Details		        "+"\n"  + "*************** "+" \n " +
    	  "job number : "+job_id+" \n " + "job size : "+VM_size+" \n " + " car number that this job is assigned to : "+car_id+" \n " +
    	  "the amount of time this job takes to finish in minutes : "+job_duration+"\n" +
    	  "the amount of data that this job will produce : "+data_this_job_will_produce+" \n " +  " the disk storage time: "+data_storage_time +" \n ";
            		;


return result;

        }


        void calculate_job_duration(){           // Calculates the time it takes to complete a job in a car.
            job_duration= (VM_size * 0.1)+data_storage_time;
            job_duration_remained = job_duration;
        }



    }
