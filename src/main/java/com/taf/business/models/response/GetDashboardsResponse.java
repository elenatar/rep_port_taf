package com.taf.business.models.response;

import com.taf.business.models.dto.DashboardDto;
import com.taf.business.models.dto.PageDto;
import lombok.Data;

import java.util.List;

@Data
public class GetDashboardsResponse {
    private List<DashboardDto> content;
    private PageDto page;
}
