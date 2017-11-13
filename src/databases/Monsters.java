package databases;

public class Monsters {
	private static final String name[]=new String[]{
			
	};
	private static final String[] descripiton=new String[]{
			
	};
	private static final int[] health=new int[]{
			
	};
	private static final int[] armor=new int[]{
			
	};
	private static final int[] attack=new int[]{
			
	};
	private static final float[] atkChance=new float[]{
			0.f,	0.2f,
			1.f,	0.4f,
			0.6f,	0.75f,
			0.8f,	0.8f,
			0.8f,	1.f
	};
	private static final float[] escChance=new float[]{
			0.f,	0.8f,
			0.8f,	0.8f,
			0.8f,	0.8f,
			0.8f,	0.8f,
			0.7f,	0.5f
	};
	public static float getEscapeChance(byte id){
		return escChance[id];
	}

}
