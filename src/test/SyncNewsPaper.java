package test;

class NewsPaper
{
	String todayNews;
	boolean isTodayNews=false;
	String reader;
	
	public void setTodayNews(String news)
	{
		todayNews=news;
		isTodayNews=true;
		
		synchronized(this)
		{
			notifyAll();
		}
	}
	
	public String getTodayNews()
	{
		if(isTodayNews==false)
		{
			try
			{
				synchronized(this)
				{
					System.out.println(reader+"wait 전");
					wait();
					System.out.println(reader+"wait 후");
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		return todayNews;
	}
}

class NewsWriter extends Thread
{
	NewsPaper paper;
	
	public NewsWriter(NewsPaper paper)
	{
		this.paper=paper;
	}
	public void run()
	{
		paper.setTodayNews("자바의 열기가 뜨겁습니다");
	}
}

class NewsReader extends Thread
{
	NewsPaper paper;
	
	public NewsReader(NewsPaper paper, String name)
	{
		this.paper=paper;
		paper.reader=name;
	}
	public void run()
	{
		System.out.println("오늘의 뉴스: "+paper.getTodayNews());
	}
}

class SyncNewsPaper
{
	public static void main(String[] args)
	{
		NewsPaper paper=new NewsPaper();
		NewsReader reader1=new NewsReader(paper, "reader1");
		NewsReader reader2=new NewsReader(paper, "reader1");
		NewsWriter writer=new NewsWriter(paper);

		try
		{
			reader1.start();
			reader2.start();
			
			Thread.sleep(1);			
			writer.start();
	
			reader1.join();
			reader2.join();
			writer.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}