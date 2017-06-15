import java.util.ArrayList;
import java.util.Random;
/*
 * 
 * Tarek Fouda implemented this program and got help to structure this code from souce code on https://github.com/nbsquires/EightQueens/blob/master/README
 *
 *
 */
public class NQueen1
{
    public static final int initialsize = 160;                    // Population size at start.
    public static final int noOfruns = 100;                  // Arbitrary number of test cycles.
    public static final double matingprobability = 0.8;        // Probability of two chromosomes mating. Range: 0.0 < matingprobability < 1.0
    public static final double mutation_rate = 0.001;           // Mutation Rate. Range: 0.0 < mutation_rate < 1.0
    public static final int MIN_SELECT = 10;                    // Minimum parents allowed for selection.
    public static final int MAX_SELECT = 50;                    // Maximum parents allowed for selection. Range: MIN_SELECT < MAX_SELECT < initialsize
    public static final int childrenFromGeneration = 20;      // New offspring created per generation. Range: 0 < childrenFromGeneration < MAX_SELECT.
    public static final int MINIMUM_SHUFFLES = 8;               // For randomizing starting chromosomes
    public static final int MAXIMUM_SHUFFLES = 20;    
    public static final int N = 16;                   // chess board width.
    public static int iteration = 0;
    public static int childCount = 0;
    public static int nextMutation = 0;                         // For scheduling mutations.
    public static int mutations = 0;
    public static ArrayList<Chromosome> population = new ArrayList<Chromosome>();
    
    //start of chromosome class
    public static class Chromosome
    {
        public int mData[] = new int[N];
        public double mFitness = 0.0;
        public boolean mSelected = false;
        public double mSelectionProbability = 0.0;
        public int mConflicts = 0;
    
        public Chromosome()
        {
            for(int i = 0; i < N; i++)
            {
                this.mData[i] = i;
            }
            return;
        }
        
        public void computeConflicts()
        {
            int conflicts = 0;

            
            for (int i =0;i<N;i++){
            	for(int j = i+1;j<N;j++){
            		if( ((this.mData[j] - this.mData[i]) ==  (j-i)) || (this.mData[i] == this.mData[j])){
            			 conflicts++;
            		}
            	}
            	
            }

            this.mConflicts = conflicts;
        }
 

        public int conflicts()
        {
            return this.mConflicts;
        }
    
        public double selectionProbability()
        {
            return mSelectionProbability;
        }
        
        public void selectionProbability(final double SelProb)
        {
            mSelectionProbability = SelProb;
            return;
        }
    
        public boolean selected()
        {
            return mSelected;
        }
        
        public void selected(final boolean sValue)
        {
            mSelected = sValue;
            return;
        }
    
        public double fitness()
        {
            return mFitness;
        }
        
        public void fitness(final double score)
        {
            mFitness = score;
            return;
        }
    
        public int data(final int index)
        {
            return mData[index];
        }
        
        public void data(final int index, final int value)
        {
            mData[index] = value;
            return;
        }
    } 
     // end of chromosome class 
    
    public static void initializeChromosomes()
    {
        int shuffles = 0;
        Chromosome newChromo = null;
        int chromoIndex = 0;

        for(int i = 0; i < initialsize; i++)
        {
            newChromo = new Chromosome();
            population.add(newChromo);
            chromoIndex = population.indexOf(newChromo);

            // Randomly choose the number of shuffles to perform.
            shuffles = getRandomNumber(MINIMUM_SHUFFLES, MAXIMUM_SHUFFLES);

            exchangeMutation(chromoIndex, shuffles);

            population.get(chromoIndex).computeConflicts();   // gets all conflicts for specific chromosome at chromoIndex

        }
        return;
    }
  
    public static void algorithm()
    {
        int popSize = 0;
        Chromosome thisChromo = null;

        initializeChromosomes();
        nextMutation = (int)Math.round((((int)Math.round(1.0 / mutation_rate)) - 0) * new Random().nextDouble() + 0); 

        
        while(iteration < noOfruns+1)
        {
            popSize = population.size();
            getFitness();
            rouletteSelection();
            mating();
            prepNextiteration();
            iteration++;

        }
        
        System.out.println("done.");
        int answers=0;
        if(iteration != noOfruns){
        	//int answers=0;
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                thisChromo = population.get(i);
                if(thisChromo.conflicts() == 0){
                	answers = answers+1;
                }
            }
        }
        
        System.out.println("After " + (iteration-1) + " iterations, I got " +  answers + " solutions.");
        return;
    }

    public static void getFitness()
    {
        int popSize = population.size();
        Chromosome thisChromo = null;
        double bestScore = 0;
        double worstScore = 0;

        worstScore = population.get(maximum()).conflicts();

        bestScore = worstScore - population.get(minimum()).conflicts();

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.fitness((worstScore - thisChromo.conflicts()) * 100.0 / bestScore);
        }
        
        return;
    }
 
    public static void rouletteSelection()
    {
        int j = 0;
        int popSize = population.size();
        double genTotal = 0.0;
        double selTotal = 0.0;
        int maximumToSelect = getRandomNumber(MIN_SELECT, MAX_SELECT);
        double rouletteSpin = 0.0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        boolean done = false;

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            genTotal += thisChromo.fitness();
        }

        genTotal *= 0.01;

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.selectionProbability(thisChromo.fitness() / genTotal);
        }

        for(int i = 0; i < maximumToSelect; i++)
        {
            rouletteSpin = getRandomNumber(0, 99);
            j = 0;
            selTotal = 0;
            done = false;
            while(!done)
            {
                thisChromo = population.get(j);
                selTotal += thisChromo.selectionProbability();
                if(selTotal >= rouletteSpin){
                    if(j == 0){
                        thatChromo = population.get(j);
                    }else if(j >= popSize - 1){
                        thatChromo = population.get(popSize - 1);
                    }else{
                        thatChromo = population.get(j - 1);
                    }
                    thatChromo.selected(true);
                    done = true;
                }else{
                    j++;
                }
            }
        }
        return;
    }
    
    public static void mating()
    {
        int getRand = 0;
        int parentA = 0;
        int parentB = 0;
        int newIndex1 = 0;
        int newIndex2 = 0;
        Chromosome newChromo1 = null;
        Chromosome newChromo2 = null;

        for(int i = 0; i < childrenFromGeneration; i++)
        {
            parentA = chooseParent();
            // Test probability of mating.
            getRand = getRandomNumber(0, 100);
            if(getRand <= matingprobability * 100){
                parentB = chooseParent(parentA);
                newChromo1 = new Chromosome();
                newChromo2 = new Chromosome();
                population.add(newChromo1);
                newIndex1 = population.indexOf(newChromo1);
                population.add(newChromo2);
                newIndex2 = population.indexOf(newChromo2);
                
                // Choose either, or both of these:
                partiallyMappedCrossover(parentA, parentB, newIndex1, newIndex2);

                if(childCount - 1 == nextMutation){
                    exchangeMutation(newIndex1, 1);
                }else if(childCount == nextMutation){
                    exchangeMutation(newIndex2, 1);
                }

                population.get(newIndex1).computeConflicts();
                population.get(newIndex2).computeConflicts();

                childCount += 2;

                if(childCount % (int)Math.round(1.0 / mutation_rate) == 0){
                    nextMutation = childCount + getRandomNumber(0, (int)Math.round(1.0 / mutation_rate));
                }
            }
        } 
        return;
    }
    
    public static void partiallyMappedCrossover(int chromA, int chromB, int child1, int child2)
    {
        int j = 0;
        int item1 = 0;
        int item2 = 0;
        int pos1 = 0;
        int pos2 = 0;
        Chromosome thisChromo = population.get(chromA);
        Chromosome thatChromo = population.get(chromB);
        Chromosome newChromo1 = population.get(child1);
        Chromosome newChromo2 = population.get(child2);
        int crossPoint1 = getRandomNumber(0, N - 1);
        int crossPoint2 = getExclusiveRandomNumber(N - 1, crossPoint1);
        
        if(crossPoint2 < crossPoint1){
            j = crossPoint1;
            crossPoint1 = crossPoint2;
            crossPoint2 = j;
        }

        // Copy Parent genes to offspring.
        for(int i = 0; i < N; i++)
        {
            newChromo1.data(i, thisChromo.data(i));
            newChromo2.data(i, thatChromo.data(i));
        }

        for(int i = crossPoint1; i <= crossPoint2; i++)
        {
            // Get the two items to swap.
            item1 = thisChromo.data(i);
            item2 = thatChromo.data(i);

            // Get the items//  positions in the offspring.
            for(j = 0; j < N; j++)
            {
                if(newChromo1.data(j) == item1){
                    pos1 = j;
                }else if(newChromo1.data(j) == item2){
                    pos2 = j;
                }
            } // j

            // Swap them.
            if(item1 != item2){
                newChromo1.data(pos1, item2);
                newChromo1.data(pos2, item1);
            }

            // Get the items//  positions in the offspring.
            for(j = 0; j < N; j++)
            {
                if(newChromo2.data(j) == item2){
                    pos1 = j;
                }else if(newChromo2.data(j) == item1){
                    pos2 = j;
                }
            } // j

            // Swap them.
            if(item1 != item2){
                newChromo2.data(pos1, item1);
                newChromo2.data(pos2, item2);
            }

        } // i
        return;
    }
    
    public static void exchangeMutation(final int index, final int exchanges)
    {
        int i =0;
        int tempData = 0;
        Chromosome thisChromo = null;
        int gene1 = 0;
        int gene2 = 0;
        boolean done = false;
        
        thisChromo = population.get(index);

        while(!done)
        {
            gene1 = getRandomNumber(0, N - 1);
            gene2 = getExclusiveRandomNumber(N - 1, gene1);

            // Exchange the chosen genes
            tempData = thisChromo.data(gene1);
            thisChromo.data(gene1, thisChromo.data(gene2));
            thisChromo.data(gene2, tempData);

            if(i == exchanges){
                done = true;
            }
            i++;
        }
        mutations++;
        return;
    }
    
    public static int chooseParent()
    {
        // Overloaded function, see also "chooseparent(ByVal parentA As Integer)".
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done = false;

        while(!done)
        {
            // Randomly choose an eligible parent.
            parent = getRandomNumber(0, population.size() - 1);
            thisChromo = population.get(parent);
            if(thisChromo.selected() == true){
                done = true;
            }
        }

        return parent;
    }

    public static int chooseParent(final int parentA)
    {
        // Overloaded function, see also "chooseparent()".
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done = false;

        while(!done)
        {
            // Randomly choose an eligible parent.
            parent = getRandomNumber(0, population.size() - 1);
            if(parent != parentA){
                thisChromo = population.get(parent);
                if(thisChromo.selected() == true){
                    done = true;
                }
            }
        }

        return parent;
    }
    
    public static void prepNextiteration()
    {
        int popSize = 0;
        Chromosome thisChromo = null;

        // Reset flags for selected individuals.
        popSize = population.size();
        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.selected(false);
        }
        return;
    }

    public static int getRandomNumber(final int low, final int high)
    {
        return (int)Math.round((high - low) * new Random().nextDouble() + low);
    }
    
    public static int getExclusiveRandomNumber(final int high, final int except)
    {
        boolean done = false;
        int getRand = 0;

        while(!done)
        {
            getRand = new Random().nextInt(high);
            if(getRand != except){
                done = true;
            }
        }

        return getRand;
    }
 
    public static int minimum()
    {
        // same as maximum method down there
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                if(i != winner){             
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.conflicts() < thatChromo.conflicts()){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }
            if(foundNewWinner == false){
                done = true;
            }
        }
        return winner;
    }

    public static int maximum()
    {
        // Returns an array indeex of the chromosoe with the most attacks 
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                if(i != winner){             // don4t compare to urself
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.conflicts() > thatChromo.conflicts()){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }
            if(foundNewWinner == false){
                done = true;
            }
        }
        return winner;
    }
    
    public static void main(String[] args)
    {
        algorithm();
        return;
    }

}