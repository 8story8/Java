package step4;

import java.util.Random;
import java.util.TreeSet;

public class LottoService 
{	
	public TreeSet<Integer> createLottoNum()
	{
		// �ߺ��� ������� �ʰ� ���ĵǱ� ���� TreeSet�� �����ؼ� �̿�
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		// ������ ���� �߻���Ű�� ���� Random�� �����ؼ� �̿�
		Random r = new Random();
		
		// �ߺ��� ������ ���� ��ȯ�� �� �����Ƿ� set�� size�� 6���� ���� ���� ��� �����ϵ��� while���� �̿�
		while(ts.size() < 6)
		{
			ts.add(r.nextInt(45) + 1);   // 0 ~ 44���� ������ ���� ��ȯ�ǹǷ� +1�ؼ� set�� �߰�
		}
		
		return ts;
	}
}
