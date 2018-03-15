package step6;

import java.io.File;

public class MoveService 
{

	public void excute(String orgDir, String destDir, String ext) 
	{
		// �̵��� ���丮�� ����
		new File(destDir).mkdirs();
		
		// ���丮 ��ü�κ��� ���� ��ü �迭�� ��ȯ
		File orgFile[] = new File(orgDir).listFiles();
		
		for(int i = 0; i < orgFile.length; i++)
		{
			if(orgFile[i].isFile() && orgFile[i].getName().endsWith(ext))   // �����̰� ext�� ������
			{
				orgFile[i].renameTo(new File(destDir + File.separator + orgFile[i].getName()));   // destDir�� �̵�
			}
		}
	}
}

