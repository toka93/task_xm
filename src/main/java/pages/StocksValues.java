package pages;


import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StocksValues {

	public String symbol;
	public String  minspread;
	public  String minmaxTradeSize;
	public String marginPercentage;
	public String longSwap;
	public String shortSwap;
	public String limit;
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StocksValues))
			return false;
		if (obj == this)
			return true;

		StocksValues rowValues = (StocksValues) obj;

		return new EqualsBuilder()
				.append(symbol, rowValues.symbol)
				.append(minspread, rowValues.minspread)
				.append(minmaxTradeSize, rowValues.minmaxTradeSize)
				.append(marginPercentage, rowValues.marginPercentage)
				.append(longSwap, rowValues.longSwap)
				.append(shortSwap, rowValues.shortSwap)
				.append(limit, rowValues.limit)
				
			
				.isEquals();
	}
	
	
	
	
	
	
	
	
}
