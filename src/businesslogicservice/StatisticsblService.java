package businesslogicservice;

import java.util.Date;
import java.util.List;

public interface StatisticsblService {

	public List<Object>  queryStatistics (Date begindate, Date enddate);
}
