import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

    public LinkedList<CourseDBElement>[] hashTable;


    public CourseDBStructure(int numberOfCourses) {
        hashTable = new LinkedList[numberOfCourses];
    }

    public CourseDBStructure(String string, int hashTableSize){
        hashTable = new LinkedList[hashTableSize];
    }

    public int getTableSize() {
        return hashTable.length;
    }

    public void add(CourseDBElement course) {
        int hashCode = course.hashCode();
        int index = hashCode%hashTable.length;
        if (hashTable[index] == null){
            hashTable[index] = new LinkedList<CourseDBElement>();
            hashTable[index].add(course);
        }
        else if (hashTable[index] != null){
            hashTable[index].add(course);
        }
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        
    	String stringCRN = Integer.toString(crn);
        int hashCode = stringCRN.hashCode();
        int index = hashCode%hashTable.length;

        for ( int x = 0 ; x < hashTable[index].size(); x++) {
        	if (hashTable[index].get(x).getCRN() == crn)
        		return hashTable[index].get(x);
        }
        throw new IOException();
    }

}