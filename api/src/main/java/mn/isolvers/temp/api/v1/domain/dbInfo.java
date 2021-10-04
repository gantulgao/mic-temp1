package mn.isolvers.temp.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dbInfo {

    private Integer Ccode;
    private Integer LID;
    private Long LDUN;
    private String LCUR;
    private String LTULDATE;
    private String LDED;
    private LocalDateTime LWDATE;
    private LocalDateTime LDATE;
    private Integer LCOUNT;
    private String LACCOUNT;
    private String L0C;
    private String L1C;
    private String L2C;
    private String L3C;
    private String L4C;
    private String L5C;
    private Integer LFLAG;
    private String LFOCUS1;
    private String LFOCUS2;
    private String LFOCUS;
    private String RESERVED;

//    private LocalDateTime REM;

}
