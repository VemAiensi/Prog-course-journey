package dao;

import domain.BlockSection;
import domain.Student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BlockSectionDA
{
    private List<BlockSection> blockList;

    public List<BlockSection> getBlockList() {
        return blockList;
    }
    public void setBlockList(List<BlockSection> blockList) {
        this.blockList = blockList;
    }

    public BlockSectionDA() throws FileNotFoundException
    {
        Scanner blockInfo = new Scanner(new FileReader("src/blockSection.csv"));
        blockList = new ArrayList<BlockSection>();

        while (blockInfo.hasNext())
        {
            String blockString = blockInfo.nextLine();
            String [] blockData = new String [3];
            blockData = blockString.split(",");


            BlockSection block =  new BlockSection();
            StudentDA students = new StudentDA(blockData[0]);

            block.setBlockCode(blockData[0]);
            block.setDescription(blockData[1]);
            block.setAdviser(blockData[2]);
            block.setTotalStudents(students.getStudentList().size());
            block.setStudentList(students.getStudentList());
            blockList.add(block);
        }
    }
}
