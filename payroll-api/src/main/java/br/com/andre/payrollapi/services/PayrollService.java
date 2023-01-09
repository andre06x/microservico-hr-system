package br.com.andre.payrollapi.services;

import br.com.andre.payrollapi.domain.Payroll;
import br.com.andre.payrollapi.feignClients.UserFeign;
import br.com.andre.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;
import static org.springframework.util.ObjectUtils.isEmpty;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {
    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        try {
            var user = feign.findById(workerId).getBody();
            if(user.getId() != null){
                System.out.println("not null");
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }
        }catch(FeignException.NotFound ex){
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }

        return null;
    }
}
