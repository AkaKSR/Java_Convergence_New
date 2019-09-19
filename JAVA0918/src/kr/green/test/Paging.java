package kr.green.test;

public class Paging {
	// 입력 받을 변수
	private int totalCount; // 전체 개수
	private int currentPage; // 현재 페이지
	private int pageSize; // 페이지 사이즈
	private int blockSize; // 하단에 표시될 페이지 개수

	// 계산하는 변수
	private int totalPage; // 전체 페이지 수
	private int startNo; // 시작 글번호
	private int endNo; // 끝 글번호
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호

	// 생성자
	public Paging(int totalCount, int currentPage, int pageSize, int blockSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calc();
	}

	// 계산해 주는 메서드
	private void calc() {
		if (totalCount > 0) {
			totalPage = (totalCount - 1) / pageSize + 1;
			// MariaDB는 index가 0부터 시작(1페이지: 0~9, 5페이지: 40~49)
			startNo = (currentPage - 1) * pageSize;
			// Oracle은 rowNum이 1부터 시작(1페이지: 1~10, 5페이지: 41~50)
//			startNo = (currentPage-1)*pageSize + 1;
			endNo = startNo + pageSize - 1;
			if (endNo > totalCount) endNo = totalCount; // endNo은 Oracle에서만 사용
			startPage = (currentPage-1) / blockSize * blockSize + 1;
			endPage = startPage + blockSize - 1;
			if(endPage>totalPage) endPage = totalPage;
		}
	}

	// Getter만 만든다.
	public int getTotalCount() {
		return totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	// 메서드 추가
	public String getPageInfo() {
		return "전체 : " + totalCount + "개(" + currentPage + "/" + totalPage + "Page)";
	}
	public String getPage() {
		return startNo + "~" + endNo;
	}
	
	public String getPageList() {
		StringBuilder sb = new StringBuilder();
		if (startPage>1) {
			sb.append("[이전] ");
		}
		for (int i = startPage; i <= endPage; i++) {
			sb.append("[" + i + "] ");
		}
		if (endPage<totalPage) {
			sb.append("[다음] ");
		}
		
		return sb.toString();
	}
	
	// Test Code
	public static void main(String[] args) {
		Paging paging1 = new Paging(123, 1, 10, 10);
		System.out.println(paging1.getPageInfo());
		System.out.println(paging1.getPage());
		System.out.println(paging1.getPageList());
	}
}