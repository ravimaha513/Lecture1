import java.math.BigDecimal;
import java.util.Optional;

class SamplePreprocessor {

    private final SampleNormalizer normalizer;

    SamplePreprocessor(SampleNormalizer normalizer) {
        this.normalizer = normalizer;
    }

    /*Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
        return input.filter(Objects::nonNull).filter(in -> in.compareTo(ZERO) > 0).map(Collectors.groupingBy(t -> ));
    }*/
}

class SampleNormalizer{
    Optional<Optional<BigDecimal>> normalize(BigDecimal bigDecimal){
        return Optional.of(Optional.ofNullable(bigDecimal));
    }
}