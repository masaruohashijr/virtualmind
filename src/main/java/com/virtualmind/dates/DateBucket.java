package com.virtualmind.dates;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@lombok.Data
class DateBucket {
	final Instant from;
	final Instant to;

	public static List<DateBucket> bucketize2(ZonedDateTime fromDate, 
			ZonedDateTime toDate, 
			int bucketSize, 
			ChronoUnit bucketSizeUnit) {
	    List<DateBucket> buckets = new ArrayList<>();
	    boolean reachedDate = false;
	    for (int i = 0; !reachedDate; i++) {
	        ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
	        ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
	        reachedDate = toDate.isBefore(maxDate);
	        buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
	    }

	    return buckets;
	}
	
	public static List<DateBucket> bucketize3(
	        ZonedDateTime fromDate, 
	        ZonedDateTime toDate, 
	        int bucketSize, 
	        ChronoUnit bucketSizeUnit
	    ) {
	    
	    var result = new ArrayList<DateBucket>();
	    IntStream.range(0, Integer.MAX_VALUE)
	            .mapToObj(i -> fromDate.plus(i * bucketSize, bucketSizeUnit))
	            .takeWhile(d -> d.isBefore(toDate))
	            .map(d -> d.toInstant())
	            .reduce((min, max) -> {
	                result.add(new DateBucket(min, max));
	                return max;
	            });
	    return result;
	}
	
	public static List<DateBucket> bucketize(ZonedDateTime fromDate, ZonedDateTime toDate,
		    int bucketSize, ChronoUnit bucketSizeUnit) {
			int startInclusive = 0;
			int endExclusive = endsAt(fromDate, toDate, bucketSize, bucketSizeUnit)+1;
		    List<DateBucket> intervalsList = IntStream.range(
		    		startInclusive, endExclusive
		    		)
				    .mapToObj( streamIteratedElement -> {
				    	ZonedDateTime minDate, maxDate;
				    	minDate = fromDate.plus(streamIteratedElement * bucketSize, bucketSizeUnit);
				        maxDate = fromDate.plus((streamIteratedElement + 1) * bucketSize, bucketSizeUnit);
				    	return new DateBucket(minDate.toInstant(), maxDate.toInstant());
				    })
				    .collect(Collectors.toList());
			return intervalsList;
		}
	
	private static int endsAt(ZonedDateTime fromDate, ZonedDateTime toDate,
		    int bucketSize, ChronoUnit bucketSizeUnit) {
		Long between = bucketSizeUnit.between(fromDate, toDate);
		int intValue = between.intValue();
		return intValue/bucketSize;
	}
	
	public static void main(String[] args) {
		ZonedDateTime fromDate = ZonedDateTime.now();
	    ZonedDateTime toDate = fromDate.plus(1000,ChronoUnit.HOURS);
		int bucketSize = 5;
		List<DateBucket> list = bucketize(fromDate, toDate, bucketSize, ChronoUnit.HOURS);
		list.forEach(i->{
			System.out.println(i);
		});
	}
}
