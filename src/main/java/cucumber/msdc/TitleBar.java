package cucumber.msdc;

public class TitleBar {
	
	private String homeTeam;
	private String awayTeam;
	private String score;
	private String homeTeamImgSrc;
	private String homeTeamImgHt;
	private String homeTeamImgWidth;
	private String awayTeamImgSrc;
	private String awayTeamImgHt;
	private String awayTeamImgWidth;
	
	public TitleBar(String homeTeam, String awayTeam, String score, String homeTeamImgSrc, String homeTeamImgHt, String homeTeamImgWidth, String awayTeamImgSrc, String awayTeamImgHt, String awayTeamImgWidth){
		this.homeTeam=homeTeam;
		this.awayTeam=awayTeam;
		this.score=score;
		this.homeTeamImgSrc=homeTeamImgSrc;
		this.homeTeamImgHt=homeTeamImgHt;
		this.homeTeamImgWidth=homeTeamImgWidth;
		this.awayTeamImgSrc=awayTeamImgSrc;
		this.awayTeamImgHt=awayTeamImgHt;
		this.awayTeamImgWidth=awayTeamImgWidth;
	}
	
	public String getHomeTeam(){
		return homeTeam;
	}
	
	public String getAwayTeam(){
		return awayTeam;
	}
	
	public String getScore(){
		return score;
	}

}
