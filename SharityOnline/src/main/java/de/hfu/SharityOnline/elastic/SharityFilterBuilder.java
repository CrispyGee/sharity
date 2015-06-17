package de.hfu.SharityOnline.elastic;

import java.util.List;

import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;

import de.hfu.SharityOnline.innerObjects.Availability;
import de.hfu.SharityOnline.innerObjects.Salutation;
import de.hfu.SharityOnline.setup.TimeHelper;

public class SharityFilterBuilder {

  public static FilterBuilder combineAllFilters(List<FilterBuilder> filters) {
    return FilterBuilders.andFilter(filters.toArray(new FilterBuilder[filters.size()]));
  }

  public static FilterBuilder buildActiveOnlyFilter() {
    return FilterBuilders.termFilter("active", true);
  }

  public static FilterBuilder buildSalutationFilter(Salutation sal) {
    return FilterBuilders.termFilter("salutation", sal.name());
  }

  public static FilterBuilder buildHometownFilter(String hometown) {
    return FilterBuilders.prefixFilter("userMongo.hometown", hometown);
  }

  public static FilterBuilder buildAgeFilter(int age) {
    long birthdayTimeInMillis = System.currentTimeMillis() - (TimeHelper.YEAR_IN_MILLIS * age);
    return FilterBuilders.rangeFilter("birthday").from(birthdayTimeInMillis - TimeHelper.YEAR_IN_MILLIS*2)
        .to(birthdayTimeInMillis + TimeHelper.YEAR_IN_MILLIS*2);
  }

  public static FilterBuilder buildPriceFilter(double price) {
    return FilterBuilders.rangeFilter("price").from(price - 10.0).to(price + 10.0);
  }

  public static FilterBuilder buildAvailabilityFilter(Availability availability) {
    return FilterBuilders.termFilter("availability", availability.name());
  }

  public static FilterBuilder buildCategoryFilter(String category_id) {
    return FilterBuilders.termFilter("category._id", category_id);
  }

  public static FilterBuilder buildCreationdateFilter(long timestamp) {
    return FilterBuilders.rangeFilter("creation_date").from(timestamp - TimeHelper.MONTH_IN_MILLIS).to(timestamp + TimeHelper.MONTH_IN_MILLIS);
  }
  
}
