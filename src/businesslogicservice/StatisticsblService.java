package businesslogicservice;

import java.util.Date;
import java.util.List;

public interface StatisticsblService {

	public List<LogisticsDocumentPO>  queryStatistics (Date begindate, Date enddate);
}
