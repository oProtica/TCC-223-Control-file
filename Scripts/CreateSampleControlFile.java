import java.util.Base64;
import java.nio.charset.StandardCharsets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateSampleControlFile {

    public static void writePlainTextStringArrayToFile(BufferedWriter writer, String startMarker, String[] lines, String endMarker)
    {

        try {
		 writer.write(startMarker);
		writer.newLine();
		
		for (int i=0; i < lines.length; i += 3)
		    {
			writer.write(lines[i]);
			writer.newLine();
			writer.write(lines[i+1]);
			writer.newLine();
			writer.write(lines[i+2]);
			writer.newLine();
		    }
		writer.write(endMarker);
		writer.newLine();
	    } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeBase64EncodedStringArrayToFile(BufferedWriter writer, String startMarker, String[] lines, String endMarker)
    {
	Base64.Encoder encoder = Base64.getEncoder();
        byte[] originalBytes; 
        String encodedString; 

        try {
		 writer.write(startMarker);
		writer.newLine();
		
		for (int i=0; i < lines.length; i += 3)
		    {
			writer.write(lines[i]);
			writer.newLine();
			originalBytes = lines[i+1].getBytes(StandardCharsets.UTF_8);
			encodedString = encoder.encodeToString(originalBytes);
			writer.write(encodedString);
			writer.newLine();
			writer.write(lines[i+2]);
			writer.newLine();
		    }
		writer.write(endMarker);
		writer.newLine();
	    } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        String [] systemLines1 = {
	    "<DBFileName>",
	    "CSC-223-CRM_database",
	    "</DBFileName>",
	    "<Save>",
	    "",
	    "</Save>",
	    "<Exit>",
	    "This line is written using CreateSampleControlFile.",
	    "</Exit>"
	};

        String [] systemLines2 = {
	    "<Output>",
	    "CSC-223-CRM_database",
	    "</Output>",
	};

	String [] createLines1 = {
	    "<Surname>",
	    "Cartledge",
	    "</Surname>",
	    "<GivenName>",
	    "Charles",
	    "</GivenName>",
	    "<Telephone>",
	    "+1-757-6332581",
	    "</Telephone>",
	    "<PostCode>",
	    "23452",
	    "</PostCode>"	    
	};
	String [] createLines2 = {
	    "<GivenName>",
	    "ball-bat",
	    "</GivenName>",
	    "<Telephone>",
	    "+91 (22) 1234-5678",
	    "</Telephone>",
	    "<Surname>",
	    "San Antonio",
	    "</Surname>",
	    "<PostCode>",
	    "SW1A 1AA",
	    "</PostCode>"
	};

	String [] retrieveLines = {
	    "<CRMID>",
	    "1",
	    "</CRMID>",
	    "<CRMID>",
	    "Q2FydGxlZGdl",
	    "</CRMID>"
	};

	String [] updateLines = {
	    "<CRMID>",
	    "Q2FydGxlZGdl",
	    "</CRMID>",
	    "<GivenName>",
	    "Henry",
	    "</GivenName>"
	};

	String [] deleteLines = {
	    "<CRMID>",
	    "Q2FydGxlZGdl",
	    "</CRMID>",
	    "<CRMID>",
	    "1",
	    "</CRMID>",
	    "# A comment line",
	    "  # yet another one.",
	    "                 # this is the last one."
	};

	String [] longLines = {
	    "<Sample>",
	    "This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.  This is a short line that will be repeated many times to see what happens with a long line.",
	    "</Sample>"
	};
	
        String fileName = "sampleControlFile.txt";


        // The try-with-resources statement automatically closes the writer, preventing resource leaks.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
	    {
		writeBase64EncodedStringArrayToFile(writer, "<System>", systemLines1, "</System>");
		writeBase64EncodedStringArrayToFile(writer, "<Create>", createLines1, "</Create>");
		writeBase64EncodedStringArrayToFile(writer, "<Create>", createLines2, "</Create>");
		writePlainTextStringArrayToFile(writer,"<Retrieve>", retrieveLines, "</Retrieve>");
		writeBase64EncodedStringArrayToFile(writer, "<System>", systemLines2, "</System>");
		writeBase64EncodedStringArrayToFile(writer,"<Update>", updateLines, "</Update>");
		writePlainTextStringArrayToFile(writer,"<Delete>", deleteLines, "</Delete>");
		writeBase64EncodedStringArrayToFile(writer,"<Ignore>", longLines, "</Ignore>");
		System.out.println("Successfully wrote to the file.");

	    } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
