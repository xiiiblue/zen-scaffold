package com.bluexiii.zenscaffold.component;

import com.bluexiii.zenscaffold.domain.TdBProduct;
import com.bluexiii.zenscaffold.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bluexiii on 10/08/2017.
 */
@Component
public class StaticModelMapperComponent {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO productEntityToDTO(TdBProduct entity) {
        return modelMapper.map(entity, ProductDTO.class);
    }
}
