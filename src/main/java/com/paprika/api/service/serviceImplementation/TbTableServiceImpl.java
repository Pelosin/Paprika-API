package com.paprika.api.service.serviceImplementation;

import com.paprika.api.domain.TbTable;
import com.paprika.api.exception.BadRequestException;
import com.paprika.api.repo.TableRepo;
import com.paprika.api.service.TableService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TbTableServiceImpl implements TableService {

    private final @NonNull TableRepo tableRepo;

    @Override
    public TbTable save(TbTable table) {
        log.info("Saving new table {}", table.getTableNumber());
        return tableRepo.save(table);
    }

    @Override
    public Optional<TbTable> findTableByIdOrThrowBadRequest(Long id) {
        return Optional.ofNullable(tableRepo.findById(id)
                .orElseThrow(() -> new BadRequestException("Table not found")));
    }

    @Override
    public Long occupyTable(Long id) {
        TbTable tableToOccupy = findTableByIdOrThrowBadRequest(id).get();
        if(tableToOccupy.isOccupied()){
            throw new BadRequestException("The Table is Already occupied");
        }else{
            tableToOccupy.setOccupied(true);
            tableRepo.save(tableToOccupy);
            log.info("Occupying table {}", tableToOccupy.getTableNumber());
            return tableToOccupy.getId();
        }
    }

    @Override
    public void leaveTable(Long id) {
        TbTable tableToLeave = findTableByIdOrThrowBadRequest(id).get();
        if (tableToLeave.isOccupied()){
            tableToLeave.setOccupied(false);
            tableRepo.save(tableToLeave);
            log.info("Leaving table {}", tableToLeave.getTableNumber());
        }else{
            throw new BadRequestException("Table was not being occupied to be leaved");
        }
    }

    @Override
    public TbTable findByTableNumber(String tableNumber) {
        return tableRepo.findByTableNumber(tableNumber);
    }

    @Override
    public List<TbTable> getTables() {
        log.info("Fetching all tables");
        return tableRepo.findAll();
    }


}
